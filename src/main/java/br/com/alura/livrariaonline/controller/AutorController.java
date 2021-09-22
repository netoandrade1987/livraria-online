package br.com.alura.livrariaonline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaonline.dto.AutorFormDto;
import br.com.alura.livrariaonline.dto.AutorListDto;
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
	public List<AutorListDto> Listar() {

		return autorService.listar();

	}

	@PostMapping
	public void cadastrar(@RequestBody @Valid AutorFormDto autorFormDto) {

		autorService.cadastrar(autorFormDto);

	}

}
