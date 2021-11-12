package br.com.alura.livrariaonline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livrariaonline.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String username);

	@Query()
	Optional <Usuario> carregarComIdComPerfis(Long idUsuario);

}
