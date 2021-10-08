package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorFormDto {

    
	private Long id;
	
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
