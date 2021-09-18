package br.com.alura.livrariaonline.modelo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.Data;

public @Data class Livro {
	
	private String titulo;
	private LocalDate dataLancamento;
	private short numeroPaginas;
	private Autor autor;
	
	

}
