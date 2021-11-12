package br.com.alura.livrariaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livrariaonline.modelo.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
