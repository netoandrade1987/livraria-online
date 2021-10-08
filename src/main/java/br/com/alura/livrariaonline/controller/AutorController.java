package br.com.alura.livrariaonline.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.livrariaonline.dto.AutorFormDto;
import br.com.alura.livrariaonline.dto.AutorDto;
import br.com.alura.livrariaonline.service.AutorService;

/**
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe é o Controller da aplicação para o objeto Autor, 
 * ela é responsável por receber os métodos de uma API Rest.
 * 
 *
 */

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@GetMapping
	public Page<AutorDto> Listar(Pageable paginacao) {

		return autorService.listar(paginacao);

	}

	@PostMapping
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorFormDto autorFormDto, UriComponentsBuilder uriBuilder) {

		AutorDto autorDto = autorService.cadastrar(autorFormDto);
		
		URI uri = uriBuilder
				.path("/autores/{id}")
				.buildAndExpand(autorDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(autorDto);

	}

}
