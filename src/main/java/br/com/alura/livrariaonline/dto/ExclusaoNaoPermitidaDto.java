package br.com.alura.livrariaonline.dto;

import java.time.LocalDateTime;

public class ExclusaoNaoPermitidaDto {
	
	private LocalDateTime timeStamp;
	private String error;
	private String mensagem;
	private String path;
	
	
	
	
	public ExclusaoNaoPermitidaDto(LocalDateTime timeStamp, String error, String mensagem, String path) {
		this.timeStamp = timeStamp;
		this.error = error;
		this.mensagem = mensagem;
		this.path = path;
	}
	
	public ExclusaoNaoPermitidaDto() {}
	
	
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
	

}
