package br.com.alura.livrariaonline.service;

import java.util.Random;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.AtualizaUsuarioFormDto;
import br.com.alura.livrariaonline.dto.UsuarioDto;
import br.com.alura.livrariaonline.dto.UsuarioFormDto;
import br.com.alura.livrariaonline.infra.EnviadorDeEmailFake;
import br.com.alura.livrariaonline.infra.EnviadorDeEmailReal;
import br.com.alura.livrariaonline.modelo.Perfil;
import br.com.alura.livrariaonline.modelo.Usuario;
import br.com.alura.livrariaonline.repository.PerfilRepository;
import br.com.alura.livrariaonline.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository PerfilRepository;

//Esse dois atributos tive que instanciar na mão.
//Ficava dando Null Point Exception nas classes de testes, mesmo com a anotação @Autowired

	private BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
	
	private ModelMapper modelMapper = new ModelMapper();
	
//Obs: Tentei fazer conforme ensinado no vídeo, mas não funcionou.
//Ficou dando Null Point Exception na classe de UsuarioServiceTest
//No método cadastrar.
//mesmo com a anotação @Autowired
	
//Prod	
	@Autowired
	private EnviadorDeEmailReal enviadorDeEmail;


//	@Autowired
//	private EnviadorDeEmailFake enviadorDeEmail;
	

	public Page<UsuarioDto> listar(Pageable paginacao) {

		Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);

		return usuarios.map(u -> modelMapper.map(u, UsuarioDto.class));

	}

	@Transactional
	public UsuarioDto cadastrar(UsuarioFormDto usuarioFormDto) {
		
		

		try {
			
			Usuario usuario = modelMapper.map(usuarioFormDto, Usuario.class);
			Perfil perfil = PerfilRepository.getById(usuarioFormDto.getPerfilId());
			usuario.addPerfil(perfil);
			
			String senha = new Random().nextInt(999999)+"";
			
			usuario.setSenha(passEncoder.encode(senha));
			usuario.setId(null);
			
			usuarioRepository.save(usuario);
			
			String dest = usuario.getEmail();
			String assunto = "Livraria Alura - Bem Vindo(a)";
			String msg = String.format("Olá %s!\n\n"
					+"Segue seus dados de acesso ao sistema da Livraria : "
					+"\nLogin : %s"
					+"\nSenha : %s"
					, usuario.getNome(), usuario.getLogin(), senha);
			
			
			enviadorDeEmail.enviarEmail(dest, assunto, msg);
			
			return modelMapper.map(usuario, UsuarioDto.class);
			
		} catch (EntityNotFoundException ex) {
			
			throw new IllegalArgumentException("Error ao cadastrar um Usuário");
		}
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		


	}

	public UsuarioDto atualizar(@Valid AtualizaUsuarioFormDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remover(@NotNull Long id) {
		// TODO Auto-generated method stub
		
	}

	public UsuarioDto detalhar(@NotNull Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
