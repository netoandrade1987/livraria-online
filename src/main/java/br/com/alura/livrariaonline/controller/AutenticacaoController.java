package br.com.alura.livrariaonline.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaonline.dto.LoginFormDto;
import br.com.alura.livrariaonline.infra.security.AutenticacaoService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AutenticacaoService service;
	
	
	@PostMapping
	public String autenticar(@RequestBody @Valid LoginFormDto dto) {
		
		//autenticar - verificar se está valido no banco
		//gerar o token
		//retorna o token
		
		
		return service.autenticar(dto);
		
		
		
		
		
		
	}
	
	

}
