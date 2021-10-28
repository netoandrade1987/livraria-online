package br.com.alura.livrariaonline.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.AutorDto;
import br.com.alura.livrariaonline.dto.AutorFormDto;
import br.com.alura.livrariaonline.modelo.Autor;
import br.com.alura.livrariaonline.repository.AutorRepository;


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
	
	@Autowired
	private AutorRepository  autorRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	
		public Page<AutorDto> listar(Pageable paginacao){
			
			Page<Autor> autores = autorRepository.findAll(paginacao);
			
			return autores.map(autor -> modelMapper.map(autor, AutorDto.class));
			
			
		}
	
		@Transactional
		public AutorDto cadastrar(AutorFormDto autorFormDto) {
			
			Autor autor = modelMapper.map(autorFormDto, Autor.class);
			
			//autor.setId(null);
				
			autorRepository.save(autor);
			
			return modelMapper.map(autor, AutorDto.class);
			
			
		}
	
	
	

}
