package br.com.alura.livrariaonline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeDeLivroPorAutorDto {
	
	public String autor;
	public Long quantidade;
	public Double percentual;
	
	
	
	

}