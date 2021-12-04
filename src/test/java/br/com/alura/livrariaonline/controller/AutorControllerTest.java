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
class AutorControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
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
	void naoDeveriaCadastrarUmAutorComDadosIncompletos() throws Exception {
		
		String json = "{}";
		
		mvc.perform(MockMvcRequestBuilders
				
				.post("/livros")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.header("Authorization", "Bearer "+token)
				
				)
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
		
	}
	
	
	@Test
	void deveriaCadastrarUmAutorComDadosCompletos() throws Exception {
		
		String autorJson = "{ \"nome\" : \"Joao da Silva\", \"email\" : \"teste@teste\", "
				+ "\"dataNascimento\" : \"01/12/1957\", \"miniCurriculo\"  : \"html css javascript PHP\"}";
		
		mvc.perform(
				MockMvcRequestBuilders.post("/autores")
				.contentType(MediaType.APPLICATION_JSON)
				.content(autorJson)
				.header("Authorization", "Bearer "+token)
				)
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().exists("Location"))
				.andExpect(MockMvcResultMatchers.content().json(autorJson));
		
		System.out.println("Autor Cadastrado com sucesso!!");
		
		
	}
	

}
