package br.com.alura.livrariaonline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public @Data class UsuarioDto {


	private Long id;	
	private String nome;
	private String login;

}
