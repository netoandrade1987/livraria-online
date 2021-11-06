package br.com.alura.livrariaonline.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.livrariaonline.dto.AtualizaUsuarioFormDto;
import br.com.alura.livrariaonline.dto.UsuarioDto;
import br.com.alura.livrariaonline.dto.UsuarioFormDto;
import br.com.alura.livrariaonline.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public Page<UsuarioDto> listar(Pageable paginacao) {

		return service.listar(paginacao);

	}

	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioFormDto usuarioFormDto,
			
		UriComponentsBuilder uriBuilder) {

		 UsuarioDto usuarioDto =  service.cadastrar(usuarioFormDto);
		
		 URI uri = uriBuilder
				 .path("/usuarios/{id}")
				 .buildAndExpand(usuarioDto.getId())
				 .toUri();
		
		return ResponseEntity.created(uri).body(usuarioDto);

	}
	
	
	@PutMapping
	public ResponseEntity<UsuarioDto> atualizar(@RequestBody @Valid AtualizaUsuarioFormDto dto) {

		UsuarioDto UsuarioDtoAtualizado = service.atualizar(dto);
		
			return ResponseEntity.ok(UsuarioDtoAtualizado);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDto> remover(@PathVariable @NotNull Long id) {

		 	service.remover(id);
		
			return ResponseEntity.noContent().build();

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> detalhar(@PathVariable @NotNull Long id){
		
		UsuarioDto dto = service.detalhar(id);
		
		return ResponseEntity.ok(dto);
	}
	
	

}
