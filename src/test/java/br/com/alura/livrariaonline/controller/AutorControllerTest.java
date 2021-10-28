package br.com.alura.livrariaonline.controller;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Transactional
class AutorControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void naoDeveriaCadastrarUmAutorComDadosIncompletos() throws Exception {
		
		String json = "{}";
		
		
		mvc.perform(MockMvcRequestBuilders
				
				.post("/livros")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
		
	}
	
	
	@Test
	void deveriaCadastrarUmAutorComasInformacoesCompletas() throws Exception {
		
		String autorJson = "{ \"nome\" : \"Joao da Silva\", \"email\" : \"teste@teste\", "
				+ "\"dataNascimento\" : \"01/12/1957\", \"miniCurriculo\"  : \"html css javascript PHP\"}";
		
		mvc.perform(
				MockMvcRequestBuilders.post("/autores")
				.contentType(MediaType.APPLICATION_JSON)
				.content(autorJson))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().exists("Location"))
				.andExpect(MockMvcResultMatchers.content().json(autorJson));
		
		System.out.println("Autor Cadastrado com sucesso!!");
		
		
	}
	

}
