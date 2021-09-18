/**
 * 
 */
package br.com.alura.livrariaonline.modelo;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author neto_
 *
 */
public @Data class Autor {
	
	private int id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String miniCurriculo;
	
	
	@Override
	public String toString() {
		return "Autor [id=" + this.id + ", nome=" + this.nome + ", email=" + this.email + ", dataNascimento=" + this.dataNascimento + "]";
	}
	
		
	

}
