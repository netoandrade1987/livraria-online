package br.com.alura.livrariaonline.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public @Data class UsuarioDto {

	@Positive
	@NotNull
	private Long id;	
	
	@NotBlank
	private String nome;
	@NotBlank
	private String login;

}
