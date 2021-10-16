package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.com.alura.livrariaonline.modelo.Autor;
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
 * Descrição: Essa classe modela um objeto do tipo LivroListDto. 
 * Essa classe é utilizada para listar os livros cadastrados.
 * Listamos o ID e Nome do Autor de cada livro também.
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public  class LivroDto {
	
	private Long id;
	
	private String titulo;
	
	private LocalDate dataLancamento;
	
	private Integer numeroPaginas;
	
	//	private AutorDto autorDto;
	
	private Long  autorId;
	

		

}
