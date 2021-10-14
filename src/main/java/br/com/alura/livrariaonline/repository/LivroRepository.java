package br.com.alura.livrariaonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livrariaonline.dto.QuantidadeDeLivroPorAutorDto;
import br.com.alura.livrariaonline.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	
	@Query("select new br.com.alura.livrariaonline.dto.QuantidadeDeLivroPorAutorDto("
			+ "a.nome, "
			+ "count(*), "
			+ "(count(*) * 100.0  / (select count(*) from Livro) )) "
			+ "FROM Livro lv "
			+ "JOIN lv.autor a "
			+ "group by a.id")
	List<QuantidadeDeLivroPorAutorDto> quantidadeDeLivroPorAutorDto();

	

}
