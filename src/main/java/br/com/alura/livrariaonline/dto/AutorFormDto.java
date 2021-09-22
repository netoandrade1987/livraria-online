package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


import lombok.Data;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * @
 * 
 * Descrição: Essa classe modela um objeto do tipo AutorFormDto. 
 * Essa classe é utilizada no cadastro de Autor.
 *
 */

public @Data class AutorFormDto {

    @Positive
	private int id;
	
	@NotBlank
	@Size(min=5)
	private String nome;
	
	@NotBlank
	@Size(min=10)
	private String email;
	
	@PastOrPresent
	private LocalDate dataNascimento;
	
	@NotBlank
	@Size(min=5)
	private String miniCurriculo;

}
