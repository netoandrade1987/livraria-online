package br.com.alura.livrariaonline.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Error500Dto {
	
	
	private LocalDateTime timeStamp;
	private String error;
	private String mensagem;
	private String path;
	
	

}
