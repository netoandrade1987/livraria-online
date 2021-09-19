package br.com.alura.livrariaonline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.AutorDto;
import br.com.alura.livrariaonline.dto.LivroListDto;
import br.com.alura.livrariaonline.dto.LivroFormDto;
import br.com.alura.livrariaonline.modelo.Livro;

@Service
public class LivroService {

	private List<Livro> livros = new ArrayList<Livro>();
	private ModelMapper modelMapper = new ModelMapper();

	public List<LivroListDto> listar() {

		return livros.stream().map(lv -> modelMapper.map(lv, LivroListDto.class))
				.collect(Collectors.toList());

	}

	public void cadastrar(LivroFormDto livroFormDto) {

		Livro livro = modelMapper.map(livroFormDto, Livro.class);
		livros.add(livro);

	}

}
