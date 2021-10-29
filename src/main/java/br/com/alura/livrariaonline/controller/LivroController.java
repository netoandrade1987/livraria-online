package br.com.alura.livrariaonline.controller;

import java.net.URI;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.livrariaonline.dto.LivroDto;
import br.com.alura.livrariaonline.dto.LivroFormDto;
import br.com.alura.livrariaonline.modelo.Livro;
import br.com.alura.livrariaonline.repository.LivroRepository;
import br.com.alura.livrariaonline.service.LivroService;

/**
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe é o Controller da aplicação para o objeto Livros, 
 * ela é responsável por receber os métodos de uma API Rest.
 * 
 *
 */

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@Autowired
	private LivroRepository repository;
	
	
	@GetMapping
	public Page<LivroDto> Listar(Pageable paginacao) {

		return livroService.listar(paginacao);

	}
	
	@PostMapping
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroFormDto livroFormDto, UriComponentsBuilder uriBuilder) {

		LivroDto livroDto = livroService.cadastrar(livroFormDto);
		
		URI uri = uriBuilder
				.path("/livros/{id}")
				.buildAndExpand(livroDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(livroDto);

	}
	
	@PutMapping
	public ResponseEntity<LivroDto> atualizar(@RequestBody @Valid LivroFormDto dto){
		
		LivroDto atualizado = livroService.atualizar(dto);
		
		return ResponseEntity.ok(atualizado);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LivroDto> remover(@PathVariable @NotNull Long id){
		
		Livro livro = repository.findById(id).
				
			orElseThrow(()-> new EntityNotFoundException());
		
		livroService.remover(livro.getId());
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDto> detalharLivro(@PathVariable @NotNull Long id){
		
		
		
		LivroDto dto =  livroService.detalharLivro(id);
		
		return ResponseEntity.ok(dto);
		
		
		
	}
	
	
	
	

}
