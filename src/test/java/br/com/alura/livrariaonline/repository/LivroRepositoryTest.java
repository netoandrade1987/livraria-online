package br.com.alura.livrariaonline.repository;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
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
	void deveriaRetornarUmRelatorioDaQuantidadeDeLivrosPublicadosPorAutorESeuPercentual() {
		
		
		Autor a1 = new Autor(
				
				"Andre da Silva",
				"andre@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		em.persist(a1);
		
		Autor a2 = new Autor(
				
				"Fernanda Nogueira",
				"FernandaNogueira@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		em.persist(a2);
		
		Autor a3 = new Autor(
				
				"Juliana Carvalho",
				"Juliana.Carvalho@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		em.persist(a3);
		
		Autor a4 = new Autor(
				
				"Rita de Assis",
				"RitadeAssis@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		em.persist(a4);
		
		Autor a5 = new Autor(
				
				"Rodrigo de Souza",
				"RodrigodeSouza@email.com",
				LocalDate.now(),
				"Autor de livros de tecnologia"
								
				);
		
		em.persist(a5);
		
		Livro l1 = new Livro(
				"Aprenda Java em 21 dias",
				LocalDate.now(),
				150,
				a1
				);
		
		em.persist(l1);
		
		Livro l2 = new Livro(
				"Como ser mais produtivo",
				LocalDate.now(),
				150,
				a2
				);
		
		em.persist(l2);
		
		Livro l3 = new Livro(
				"Aprenda a falar em publico",
				LocalDate.now(),
				150,
				a3
				);
		
		em.persist(l3);
		
		Livro l4 = new Livro(
				"Otimizando seu Tempo",
				LocalDate.now(),
				150,
				a2
				);
		
		em.persist(l4);
		
		Livro l5 = new Livro(
				"Investindo em ações na Bolsa de Valores",
				LocalDate.now(),
				150,
				a4
				);
		
		em.persist(l5);
		
		Livro l6 = new Livro(
				"Como fazer bolos incríveis",
				LocalDate.now(),
				150,
				a5
				);
		
		em.persist(l6);
		
		Livro l7 = new Livro(
				"Aprenda Python em 21 dias",
				LocalDate.now(),
				150,
				a1
				);
		
		em.persist(l7);
	
	 List<QuantidadeDeLivroPorAutorDto> relatorio =  repository.quantidadeDeLivroPorAutorDto();
		
		Assertions.assertThat(relatorio)
		.extracting(QuantidadeDeLivroPorAutorDto::getAutor,
				QuantidadeDeLivroPorAutorDto::getQuantidade,
				QuantidadeDeLivroPorAutorDto::getPercentual
				).containsExactlyInAnyOrder(
						Assertions.tuple("Andre da Silva",2L,28.571428571428573),
						Assertions.tuple("Fernanda Nogueira",2L,28.571428571428573),
						Assertions.tuple("Juliana Carvalho",1L,14.285714285714286),
						Assertions.tuple("Rita de Assis",1L,14.285714285714286),
						Assertions.tuple("Rodrigo de Souza",1L,14.285714285714286)
						
						);
		
	}

}
