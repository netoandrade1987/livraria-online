package br.com.alura.livrariaonline.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 *
 * 
 * Descrição: Essa classe modela um objeto do tipo AutorDto. 
 * Essa classe é utilizada na listagem dos Livros.
 *
 */

public @Data class AutorDto {
	
	@Positive
	private int id;
	
	@NotBlank
	@Size(min=5)
	private String nome;

}
