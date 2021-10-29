package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * 
 *          Descrição: Essa classe modela um objeto do tipo LivroFormDto. Essa
 *          classe é utilizada no cadastro de livros, precisamos cadastrar um
 *          objeto do tipo autor também.
 *
 */

public class LivroFormDto {

	private Long id;

	@NotBlank
	@Size(min = 5, max = 255)
	private String titulo;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@PastOrPresent
	private LocalDate dataLancamento;

	@Positive
	@Min(value = 100)
	private Integer numeroPaginas;

	@NotNull
	@JsonAlias("autor_id")
	private Long autorId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}

	public LivroFormDto(Long id, @NotBlank @Size(min = 5, max = 255) String titulo,
			@NotNull @PastOrPresent LocalDate dataLancamento, @Positive @Min(100) Integer numeroPaginas,
			@NotNull Long autorId) {

		this.id = id;
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.numeroPaginas = numeroPaginas;
		this.autorId = autorId;
	}

	public LivroFormDto() {
	}

	public LivroFormDto(@NotBlank @Size(min = 5, max = 255) String titulo,
			@NotNull @PastOrPresent LocalDate dataLancamento, @Positive @Min(100) Integer numeroPaginas,
			@NotNull Long autorId) {

		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.numeroPaginas = numeroPaginas;
		this.autorId = autorId;
	}

}
