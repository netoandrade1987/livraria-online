package br.com.alura.livrariaonline.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.LivroDto;
import br.com.alura.livrariaonline.dto.LivroFormDto;
import br.com.alura.livrariaonline.modelo.Autor;
import br.com.alura.livrariaonline.modelo.Livro;
import br.com.alura.livrariaonline.repository.AutorRepository;
import br.com.alura.livrariaonline.repository.LivroRepository;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe é responsável por realizar o cadastro 
 * e listagem dos livros.
 *
 */

@Getter
@Setter
@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public Page<LivroDto> listar(Pageable paginacao) {
		
		Page<Livro> livros = livroRepository.findAll(paginacao);

		return livros.map(livro -> modelMapper.map(livro, LivroDto.class));

	}
	
	@Transactional
	public LivroDto cadastrar(LivroFormDto livroFormDto) {

//		Livro livro = modelMapper.map(livroFormDto, Livro.class);
//		return modelMapper.map(livroRepository.save(livro), LivroDto.class);
		
		Livro livro = modelMapper.map(livroFormDto, Livro.class);
		Autor autor = autorRepository.getById(livroFormDto.getAutorId());
		
		livro.setId(null);
		livro.setAutor(autor);
		
		return modelMapper.map(livroRepository.save(livro), LivroDto.class);
		
		
	}

}
