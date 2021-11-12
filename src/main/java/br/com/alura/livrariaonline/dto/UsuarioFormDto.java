package br.com.alura.livrariaonline.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class UsuarioFormDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String login;
	
	@NotBlank
	@JsonAlias("perfil_id")
	private Long perfilId;
	

}
