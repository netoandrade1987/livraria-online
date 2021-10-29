package br.com.alura.livrariaonline.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe modela um objeto do tipo Livro. 
 *
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table ( name="livros")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	@Column( name = "dataLancamento")
	private LocalDate dataLancamento;
	
	@Column(name = "numeroPaginas")
	private Integer numeroPaginas;
	
	
	@ManyToOne
	@JoinColumn
	private Autor autor;

	public Livro(String titulo, LocalDate dataLancamento, Integer numeroPaginas, Autor autor) {
		
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.numeroPaginas = numeroPaginas;
		this.autor = autor;
	}
	
	
	public void atualizaDados(String titulo, LocalDate dataLancamento, Integer numeroPaginas, Long autorId) {
		
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.numeroPaginas = numeroPaginas;
		this.autor.setId(autorId);
		
	}
	
	
	
	
	

}
