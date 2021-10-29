package br.com.alura.livrariaonline.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livrariaonline.dto.QuantidadeDeLivroPorAutorDto;
import br.com.alura.livrariaonline.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	
	@Query("select new br.com.alura.livrariaonline.dto.QuantidadeDeLivroPorAutorDto("
			+ "a.nome, "
			+ "count(*), "
			+ "(count(*) * 100.0  / (select count(*) from Livro) ) ) "
			+ "FROM Livro l "
			+ "JOIN l.autor a "
			+ "group by a.nome")
	List<QuantidadeDeLivroPorAutorDto> quantidadeDeLivroPorAutorDto();

	 boolean existsByAutorId(Long id);

	

}
