package br.com.alura.livrariaonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaonline.dto.QuantidadeDeLivroPorAutorDto;
import br.com.alura.livrariaonline.service.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {
	
	@Autowired
	private RelatorioService service;
	
	@GetMapping("/livros-autor")
	public List<QuantidadeDeLivroPorAutorDto> relatorioQuantidadeDeLivroPorAutor(){
		
		
		return service.relatorioQuantidadeDeLivroPorAutor();
		
		
		
		
	}
	

}
