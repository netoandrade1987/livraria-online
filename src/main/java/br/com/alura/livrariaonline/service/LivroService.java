package br.com.alura.livrariaonline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.LivroDto;
import br.com.alura.livrariaonline.dto.LivroFormDto;
import br.com.alura.livrariaonline.modelo.Livro;

@Service
public class LivroService {
	
	private List<Livro> livros = new ArrayList<Livro>();
	private List<LivroDto> livrosDto = new ArrayList<LivroDto>();
	
	
	private ModelMapper modelMapper = new ModelMapper();
	
	
	public List<LivroDto> listar(){
		
		for (Livro livro : livros) {
			
			LivroDto livroDto = new LivroDto();
			livroDto.setAutor(livro.getAutor());
			livroDto.setTitulo(livro.getTitulo());
			livroDto.setNumeroPaginas(livro.getNumeroPaginas());
			livroDto.setDataLancamento(livro.getDataLancamento());
			
			livrosDto.add(livroDto);
			
		}
		
		return livrosDto;
		
	}
	
	public void cadastrar(LivroFormDto livroFormDto) {
		
		Livro livro = modelMapper.map(livroFormDto, Livro.class);
		livros.add(livro);
		
		
	}
	
	
	

}
