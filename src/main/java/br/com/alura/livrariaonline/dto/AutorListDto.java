package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.Data;

public @Data class AutorListDto {
	
	private int id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String miniCurriculo;

}
