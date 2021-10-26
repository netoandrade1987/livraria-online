package br.com.alura.livrariaonline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author neto_
 * 
 * Classe para repsentar mensagens de error de Bad Request.
 * Status code 400.
 *
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Error400Dto {
	
	
	private String campo;
	private String mensagem;
	
	

}
