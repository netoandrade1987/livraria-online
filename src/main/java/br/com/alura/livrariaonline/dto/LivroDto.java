package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import br.com.alura.livrariaonline.modelo.Autor;
import lombok.Data;

public @Data class LivroDto {
	
	@NotBlank
	@Size(min=10)
	private String titulo;
	
	@PastOrPresent
	private LocalDate dataLancamento;
	
	
	private short numeroPaginas;
	
	private Autor autor;
	

		

}
