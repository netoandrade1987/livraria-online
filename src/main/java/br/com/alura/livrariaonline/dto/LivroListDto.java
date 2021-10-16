package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class LivroListDto {
	
	private Long id;
	
	private String titulo;
	
	private LocalDate dataLancamento;
	
	private Integer numeroPaginas;
	
	private Long autor;

}
