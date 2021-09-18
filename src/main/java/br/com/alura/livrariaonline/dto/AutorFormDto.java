package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

public @Data class AutorFormDto {
	
	private int id;
	
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
