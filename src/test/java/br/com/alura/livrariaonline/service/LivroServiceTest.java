package br.com.alura.livrariaonline.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.livrariaonline.dto.LivroDto;
import br.com.alura.livrariaonline.dto.LivroFormDto;
import br.com.alura.livrariaonline.repository.AutorRepository;
import br.com.alura.livrariaonline.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {
	
	@Mock
	private LivroRepository livrorepository;
	
	@Mock
	private AutorRepository autorRepository;
	
	@InjectMocks
	private LivroService service;
	

	@Test
	void deveriaCadastrarUmLivro() {
		
		LivroFormDto lvFormDtoDto = new LivroFormDto(
				
				"Java How To Program",
				LocalDate.now(),
				150,
				5l
				);
		
		
		LivroDto dto = service.cadastrar(lvFormDtoDto);
		
		assertEquals(lvFormDtoDto.getTitulo(), dto.getTitulo());
		assertEquals(lvFormDtoDto.getDataLancamento(), dto.getDataLancamento());
		assertEquals(lvFormDtoDto.getNumeroPaginas(), dto.getNumeroPaginas());
		
	}
	
	
	@Test
	void naodeveriaCadastrarUmLivroComUmAutorInexistente() {
		
		LivroFormDto lvFormDtoDto = new LivroFormDto(
				
				"Java How To Program",
				LocalDate.now(),
				150,
				5L
				);
		
		
		Mockito.when(autorRepository.getById(lvFormDtoDto.getAutorId()))
		.thenThrow(EntityNotFoundException.class);
		
		assertThrows(IllegalArgumentException.class, () -> service.cadastrar(lvFormDtoDto));
	
		
	}
	
	

	

}
