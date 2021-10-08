package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

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
 * 
 * 
 * Descrição: Essa classe modela um objeto do tipo AutorListDto. 
 * Essa classe é utilizada na listagem dos autores.
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public  class AutorDto {
	
	
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
