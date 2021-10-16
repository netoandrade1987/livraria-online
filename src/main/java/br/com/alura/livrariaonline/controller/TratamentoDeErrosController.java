package br.com.alura.livrariaonline.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.livrariaonline.dto.Error400Dto;
import br.com.alura.livrariaonline.dto.Error500Dto;

@RestControllerAdvice
public class TratamentoDeErrosController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<Error400Dto> tratarError400(MethodArgumentNotValidException ex){
		
		return ex
				.getFieldErrors()
				.stream()
				.map(error->new Error400Dto(error.getField(),error.getDefaultMessage()))
				.collect(Collectors.toList());
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Error500Dto tratarError400(Exception ex,  HttpServletRequest req) {
		
		
		return  new Error500Dto(
				
				LocalDateTime.now(),
				ex.getClass().toString(),
				ex.getMessage(),
				req.getRequestURI()
				
				);
		
	}
	
	
	

}
