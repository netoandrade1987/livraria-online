package br.com.alura.livrariaonline.dto;

import javax.validation.constraints.NotNull;


public class AtualizaAutorFormDto extends AutorFormDto {
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	

}
