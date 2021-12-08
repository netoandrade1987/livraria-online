package br.com.alura.livrariaonline.controller;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.alura.livrariaonline.infra.security.TokenService;
import br.com.alura.livrariaonline.modelo.Perfil;
import br.com.alura.livrariaonline.modelo.Usuario;
import br.com.alura.livrariaonline.repository.PerfilRepository;
import br.com.alura.livrariaonline.repository.UsuarioRepository;


@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Transactional
public class UsuarioControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;
	
	private String token;
	
	@BeforeEach
	private void gerarToken() {
		
		Usuario logado = new Usuario("Amaro Neto", "amaroneto", "123456");
		
		Perfil admin = perfilRepository.findById(1l).get();
		
		logado.addPerfil(admin);
		
		usuarioRepository.save(logado);
		
		Authentication authentication = new 
				
		UsernamePasswordAuthenticationToken(logado, logado.getLogin());
		
		this.token = tokenService.gerarToken(authentication);
		
	}
	
	
	@Test
	void naoDeveriaCadastrarUmUsuarioComDadosIncompletos() throws Exception {
		
		String usuarioJson = "{}";
		
		mvc.perform(MockMvcRequestBuilders
				
				.post("/usuarios")
				.contentType(MediaType.APPLICATION_JSON)
				.content(usuarioJson)
				.header("Authorization", "Bearer "+token)
				
				)
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
		
	}
	
	
	@Test
	void DeveriaCadastrarUmUsuarioComDadosCompletos() throws Exception {
		
		String json = "{ \"nome\" : \"Jose Silva\", \"login\" : \"josesilva\", \"perfilId\" : 1, \"email\" : \"teste@teste.com\"}";
		
		String usuarioCadastrado = "{ \"nome\" : \"Jose Silva\", \"login\" : \"josesilva\"}";
		
		mvc.perform(
				MockMvcRequestBuilders.post("/usuarios")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.header("Authorization", "Bearer "+token)
				)
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().exists("Location"))
				.andExpect(MockMvcResultMatchers.content().json(usuarioCadastrado));
		
		System.out.println("Usuário Cadastrado com sucesso!!");
		
		
	}
	
	
	
	
	
	

}
