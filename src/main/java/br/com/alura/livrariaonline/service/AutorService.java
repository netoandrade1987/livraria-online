package br.com.alura.livrariaonline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.AutorFormDto;
import br.com.alura.livrariaonline.dto.AutorListDto;
import br.com.alura.livrariaonline.modelo.Autor;


/**
 * @author Neto Andrade
 * @version 1.0
 * 
 * Descrição: Essa classe é responsável por realizar o cadastro 
 * e listagem dos Autores.
 *
 */

@Service
public class AutorService {
	
	private List<Autor> autores = new ArrayList<Autor>();
	private ModelMapper modelMapper = new ModelMapper();
	
	
	public List<AutorListDto> listar(){
		
		return autores.stream()
				.map(atldo-> modelMapper.map(atldo, AutorListDto.class)).
				collect(Collectors.toList());
		
	}
	
	public void cadastrar(AutorFormDto autorFormDto) {
		
		Autor autor = modelMapper.map(autorFormDto, Autor.class);
		autores.add(autor);
		
		
	}
	
	
	

}
