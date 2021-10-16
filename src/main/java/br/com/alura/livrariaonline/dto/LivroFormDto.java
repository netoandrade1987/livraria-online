package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroFormDto {
	

	private Long id;
	
	@NotBlank
	@Size(min=10, max=255)
	private String titulo;
	
	@PastOrPresent
	private LocalDate dataLancamento;
	
	@Positive
	@Min(value = 100)
	private Integer numeroPaginas;
	
	@NotNull
	@JsonAlias("autor_id")
	private Long  autorId;

}
