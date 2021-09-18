package br.com.alura.livrariaonline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.AutorDto;
import br.com.alura.livrariaonline.dto.AutorFormDto;
import br.com.alura.livrariaonline.modelo.Autor;

@Service
public class AutorService {
	
	private List<Autor> autores = new ArrayList<Autor>();
	private ModelMapper modelMapper = new ModelMapper();
	
	
	public List<AutorDto> listar(){
		
		return autores.stream()
				.map(at-> modelMapper.map(at, AutorDto.class)).
				collect(Collectors.toList());
		
	}
	
	public void cadastrar(AutorFormDto autorFormDto) {
		
		Autor autor = modelMapper.map(autorFormDto, Autor.class);
		autores.add(autor);
		
		
	}
	
	
	

}
