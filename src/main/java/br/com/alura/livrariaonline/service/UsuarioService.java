package br.com.alura.livrariaonline.service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.AtualizaUsuarioFormDto;
import br.com.alura.livrariaonline.dto.UsuarioDto;
import br.com.alura.livrariaonline.dto.UsuarioFormDto;
import br.com.alura.livrariaonline.infra.GeneratePassword;
import br.com.alura.livrariaonline.modelo.Usuario;
import br.com.alura.livrariaonline.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	

	public Page<UsuarioDto> listar(Pageable paginacao) {

		Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);

		return usuarios.map(u -> modelMapper.map(u, UsuarioDto.class));

	}

	@Transactional
	public UsuarioDto cadastrar(UsuarioFormDto usuarioFormDto) {

		Usuario usuario = modelMapper.map(usuarioFormDto, Usuario.class);
		
		usuario.setSenha(GeneratePassword.generatePass());
		
		//usuario.setId(null);
		
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
