package br.com.alura.livrariaonline.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.livrariaonline.dto.AutorDto;
import br.com.alura.livrariaonline.dto.AutorFormDto;
import br.com.alura.livrariaonline.repository.AutorRepository;

@ExtendWith(MockitoExtension.class)
class AutorServiceTest {

	

	
	
	@Mock
	private AutorRepository repository;
	
	@InjectMocks
	private AutorService service; 
	
	
	/**
	 * Método simula um cadastro de Autor, porém sem acessar a base de dados.
	 * 
	 * Teste OK.
	 * 
	 */

	@Test
	void deveriacadastrarUmAutor() {
		
				LocalDate data = LocalDate.parse("1987-10-10");
		
				AutorFormDto autorFormDto = new AutorFormDto(
					
					"Jose Mario",
					"josemario@email.com",
					data,
					"Autor de Livros de História"
						
					);
				
				
		AutorDto dto =  service.cadastrar(autorFormDto);
		
		assertEquals(autorFormDto.getNome(), dto.getNome());
		assertEquals(autorFormDto.getEmail(), dto.getEmail());
		assertEquals(autorFormDto.getDataNascimento(), dto.getDataNascimento());
		assertEquals(autorFormDto.getMiniCurriculo(), dto.getMiniCurriculo());
		
	}

}
