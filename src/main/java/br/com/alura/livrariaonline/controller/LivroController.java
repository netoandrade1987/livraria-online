package br.com.alura.livrariaonline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaonline.dto.LivroListDto;
import br.com.alura.livrariaonline.dto.LivroFormDto;
import br.com.alura.livrariaonline.modelo.Livro;
import br.com.alura.livrariaonline.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	
	@GetMapping
	public List<LivroListDto> Listar() {

		return livroService.listar();

	}
	



	@PostMapping
	public void cadastrar(@RequestBody @Valid LivroFormDto livroFormDto) {

		livroService.cadastrar(livroFormDto);

	}

}
