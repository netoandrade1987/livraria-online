package br.com.alura.livrariaonline.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;

import br.com.alura.livrariaonline.dto.Error400Dto;
import br.com.alura.livrariaonline.dto.Error500Dto;
import br.com.alura.livrariaonline.dto.ExclusaoNaoPermitidaDto;
import br.com.alura.livrariaonline.dto.RecursoNaoEncontradoDto;
import br.com.alura.livrariaonline.error.RegraDeNegocioException;

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
	
	@ExceptionHandler({EntityNotFoundException.class, EmptyResultDataAccessException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public RecursoNaoEncontradoDto tratarError404(Exception ex,  HttpServletRequest req) {
		
		
		return  new RecursoNaoEncontradoDto(
				
				LocalDateTime.now(),
				ex.getClass().toString(),
				ex.getMessage(),
				req.getRequestURI()
				
				);
			
	}
	
	
	@ExceptionHandler(RegraDeNegocioException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExclusaoNaoPermitidaDto TratarErrorExclusaoNaoPermitida(Exception ex,  HttpServletRequest req) {
		
		return  new ExclusaoNaoPermitidaDto(
				
				LocalDateTime.now(),
				ex.getClass().toString(),
				ex.getMessage(),
				req.getRequestURI()
				
				);
			
	}
	

}
