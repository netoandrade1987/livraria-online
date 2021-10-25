package br.com.alura.livrariaonline.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.livrariaonline.dto.QuantidadeDeLivroPorAutorDto;
import br.com.alura.livrariaonline.modelo.Autor;
import br.com.alura.livrariaonline.modelo.Livro;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class LivroRepositoryTest {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	

	@Test
	void deveriaRetornarRelatorioDeLivrosPorAutor() {
		
		
		Autor a1 = new Autor(
				
				"Andre da Silva",
				"andre@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		Autor a2 = new Autor(
				
				"Fernanda Nogueira",
				"FernandaNogueira@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		Autor a3 = new Autor(
				
				"Juliana Carvalho",
				"Juliana.Carvalho@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		Autor a4 = new Autor(
				
				"Rita de Assis",
				"RitadeAssis@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
						
		Autor a5 = new Autor(
				
				"Rodrigo de Souza",
				"RodrigodeSouza@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		
//		Livro(String titulo, LocalDate dataLancamento, Integer numeroPaginas, Autor autor)
		
		Livro l1 = new Livro();
		
		
		
		
		
		
	 List<QuantidadeDeLivroPorAutorDto> relatorio =  repository.quantidadeDeLivroPorAutorDto();
		
		
		
		
		
	}

}
