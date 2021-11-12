package br.com.alura.livrariaonline.infra.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.livrariaonline.modelo.Usuario;
import br.com.alura.livrariaonline.repository.UsuarioRepository;


public class VerificacaoTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;

	public VerificacaoTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		
		this.tokenService=tokenService;
		this.usuarioRepository=usuarioRepository;
		
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//recuperar o toker
		//validar o token
		//se token correto, liberacao requisição
		
		String token = request.getHeader("Authorization");
		
		if (token==null || token.isBlank()) {
			
			filterChain.doFilter(request, response);
			return;
		}
		
		token = token.replace("Bearer ","");
		boolean tokenValido = tokenService.isValido(token);
		
		if (tokenValido) {
			
			Long idUsuario = tokenService.extrairIDUsuario(token);
			Usuario logado = usuarioRepository.carregarPorIdComPerfis(idUsuario).get();
			Authentication authentication = 
		    new UsernamePasswordAuthenticationToken(logado, null, logado.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	

}
