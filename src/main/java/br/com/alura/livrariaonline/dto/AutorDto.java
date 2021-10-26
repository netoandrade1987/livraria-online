package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public  class AutorDto {
	
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private String miniCurriculo;

}
