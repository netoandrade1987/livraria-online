package br.com.alura.livrariaonline.infra.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	public String gerarToken(Authentication authentication) {
		
		Usuario logado = (Usuario) authentication.getPrincipal();
		
		
		return Jwts.builder()
				.setId(logado.getId().toString())
				.signWith(SignatureAlgorithm.HS256, "555")
				.compact()
				
				;
	}

}
