package br.com.alura.livrariaonline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author neto_
 * 
 * Classe para repsentar mensagens de error de Bad Request.
 * Status code 400.
 *
 */


@AllArgsConstructor
@Getter
public class Error400Dto {
	
	
	private String campo;
	private String mensagem;
	
	

}
