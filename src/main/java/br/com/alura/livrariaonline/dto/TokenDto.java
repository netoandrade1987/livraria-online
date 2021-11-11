package br.com.alura.livrariaonline.dto;

import lombok.Getter;

@Getter
public class TokenDto {
	
	private String token;
	
	public TokenDto() {}

	public TokenDto(String token) {
		this.token = token;
	}
	
	
	
	

}
