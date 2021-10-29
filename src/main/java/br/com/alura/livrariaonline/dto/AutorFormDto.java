package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Neto Andrade
 * @version 1.0
 * @
 * 
 * Descrição: Essa classe modela um objeto do tipo AutorFormDto. 
 * Essa classe é utilizada no cadastro de Autor.
 *
 */

public class AutorFormDto {
	

	@NotBlank
	@Size(min=5, max = 255)
	private String nome;
	
	@NotBlank
	@Size(min=6, max = 255)
	@Email(message = "{livraria.email.invalido}")
	private String email;
	
	@NotNull
	@PastOrPresent
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@NotBlank
	@Size(min=10,  max = 400)
	
	
	private String miniCurriculo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getMiniCurriculo() {
		return miniCurriculo;
	}

	public void setMiniCurriculo(String miniCurriculo) {
		this.miniCurriculo = miniCurriculo;
	}

	public AutorFormDto(@NotBlank @Size(min = 5, max = 255) String nome,
			@NotBlank @Size(min = 6, max = 255) @Email(message = "{livraria.email.invalido}") String email,
			@NotNull @PastOrPresent LocalDate dataNascimento,
			@NotBlank @Size(min = 10, max = 400) String miniCurriculo) {
		
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.miniCurriculo = miniCurriculo;
	}
	
	
	public AutorFormDto() {}
	
	
	
	

}
