package br.com.alura.livrariaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livrariaonline.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
