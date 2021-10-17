package br.com.alura.livrariaonline.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
public class AutorFormDto {

    
	
	@NotBlank
	@Size(min=5, max = 255)
	private String nome;
	
	@NotBlank
	@Size(min=6, max = 255)
	@Email()
	private String email;
	
	@NotNull
	@PastOrPresent
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@NotBlank
	@Size(min=10,  max = 400)
	private String miniCurriculo;

}
