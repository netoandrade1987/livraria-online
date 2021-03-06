package br.com.alura.livrariaonline.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author neto_
 * 
 * Classe para reprsentar mensagens de error. 
 * Server Internal Errror.
 * Status code 500. 
 * 
 *
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Error500Dto {
	
	
	private LocalDateTime timeStamp;
	private String error;
	private String mensagem;
	private String path;
	
	

}
