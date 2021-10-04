package br.com.alura.livrariaonline.modelo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import br.com.alura.livrariaonline.dto.AutorDto;
import lombok.Data;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe modela um objeto do tipo Livro. 
 *
 *
 */

public @Data class Livro {
	
	private String titulo;
	private LocalDate dataLancamento;
	private short numeroPaginas;
//	private AutorDto autor;
	private Autor autor;
	
	

}
