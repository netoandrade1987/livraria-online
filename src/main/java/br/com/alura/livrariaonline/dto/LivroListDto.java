package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe modela um objeto do tipo LivroListDto. 
 * Essa classe é utilizada para listar os livros cadastrados.
 * Listamos o ID e Nome do Autor de cada livro também.
 *
 */

public @Data class LivroListDto {
	
	@NotBlank
	@Size(min=10)
	private String titulo;
	
	@PastOrPresent
	private LocalDate dataLancamento;
	
	@Positive
	private short numeroPaginas;
	
	@NotNull
	private AutorDto autorDto;
	

		

}
