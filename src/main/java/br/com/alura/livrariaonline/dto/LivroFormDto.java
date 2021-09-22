package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.alura.livrariaonline.modelo.Autor;
import lombok.Data;


/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe modela um objeto do tipo LivroFormDto. 
 * Essa classe é utilizada no cadastro de livros, precisamos
 * cadastrar um objeto do tipo autor também.
 *
 */

public @Data class LivroFormDto {
	
	@NotBlank
	@Size(min=10)
	private String titulo;
	
	@PastOrPresent
	private LocalDate dataLancamento;
	
	@Positive
	private short numeroPaginas;
	
	@NotNull
	private AutorFormDto autor;

}
