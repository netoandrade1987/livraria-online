package br.com.alura.livrariaonline.modelo;

import java.time.LocalDate;

import lombok.Data;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe modela um objeto do tipo Autor. 
 *
 *
 */
public @Data class Autor {
	
	private int id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String miniCurriculo;
	

}
