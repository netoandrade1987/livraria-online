package br.com.alura.livrariaonline.service;

import java.util.Optional;

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
import br.com.alura.livrariaonline.infra.GeneratePassword;
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
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	

	public Page<UsuarioDto> listar(Pageable paginacao) {

		Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);

		return usuarios.map(u -> modelMapper.map(u, UsuarioDto.class));

	}

	@Transactional
	public UsuarioDto cadastrar(UsuarioFormDto usuarioFormDto) {

		Usuario usuario = modelMapper.map(usuarioFormDto, Usuario.class);
		
		Perfil perfil = PerfilRepository.getById(usuarioFormDto.getPerfilId());
		
		usuario.addPerfil(perfil);
		
		String pass = GeneratePassword.generatePass();
		
		System.out.println("A senha é: "+pass);
		
		
		usuario.setSenha(passEncoder.encode(pass));
		
		usuario.setId(null);
		
		usuarioRepository.save(usuario);
		
		return modelMapper.map(usuario, UsuarioDto.class);

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
