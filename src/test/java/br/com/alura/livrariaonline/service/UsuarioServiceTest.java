package br.com.alura.livrariaonline.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.alura.livrariaonline.dto.UsuarioDto;
import br.com.alura.livrariaonline.dto.UsuarioFormDto;
import br.com.alura.livrariaonline.infra.GeneratePassword;
import br.com.alura.livrariaonline.modelo.Perfil;
import br.com.alura.livrariaonline.repository.PerfilRepository;
import br.com.alura.livrariaonline.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

	
	@Mock
	private UsuarioRepository repository;
	
	@Mock
	private PerfilRepository perfilRepository;
	
	@InjectMocks
	private UsuarioService service; 
	
	
	/**
	 * Método simula um cadastro de Usuário, porém sem acessar a base de dados.
	 * 
	 * Teste OK.
	 * 
	 */

	@Test
	void deveriacadastrarUmUsuario() {
		
		Perfil perfil = new Perfil(1L, "ADMIN");
			
		
		UsuarioFormDto userFormDto = new UsuarioFormDto("Jose Mario", "josemario",perfil.getId());
		
		
		UsuarioDto dto =  service.cadastrar(userFormDto);
		
		Mockito.verify(repository).save(Mockito.any());
		
		assertEquals(userFormDto.getNome(), dto.getNome());
		assertEquals(userFormDto.getLogin(), dto.getLogin());
		
	}

}
