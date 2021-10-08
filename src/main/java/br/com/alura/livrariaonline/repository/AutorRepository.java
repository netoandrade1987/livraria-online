package br.com.alura.livrariaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livrariaonline.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
