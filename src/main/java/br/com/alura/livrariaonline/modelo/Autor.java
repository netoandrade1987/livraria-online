package br.com.alura.livrariaonline.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe modela um objeto do tipo Autor. 
 *
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of="id")
@Table(name = "autores")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	@Column(name = "dataNascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "miniCurriculo")
	private String miniCurriculo;

	public Autor(String nome, String email, LocalDate dataNascimento, String miniCurriculo) {

		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.miniCurriculo = miniCurriculo;
	}
	
	public void atualizaDadosDoAutor(String nome, String email, LocalDate dataNascimento, String miniCurriculo) {
		
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.miniCurriculo = miniCurriculo;
		
			
		
	}
			
			
			
			
	

	
	

}
