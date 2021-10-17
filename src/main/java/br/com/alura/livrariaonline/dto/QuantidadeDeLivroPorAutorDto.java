package br.com.alura.livrariaonline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class QuantidadeDeLivroPorAutorDto {
	
	public String autor;
	public Long quantidade;
	public Double percentual;
	
	
	
	

}
