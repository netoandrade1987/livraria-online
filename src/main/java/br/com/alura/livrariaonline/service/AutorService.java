package br.com.alura.livrariaonline.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.AtualizaAutorFormDto;
import br.com.alura.livrariaonline.dto.AutorDto;
import br.com.alura.livrariaonline.dto.AutorFormDto;
import br.com.alura.livrariaonline.error.RegraDeNegocioException;
import br.com.alura.livrariaonline.modelo.Autor;
import br.com.alura.livrariaonline.repository.AutorRepository;
import br.com.alura.livrariaonline.repository.LivroRepository;


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
	
	@Autowired
	private LivroRepository livroRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	
	
	/**
	 * Método que lista dos os registros com paginação
	 * 
	 */
	
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

		@Transactional
		public AutorDto atualizar(AtualizaAutorFormDto dto) {
			
			
				Autor autor = autorRepository.findById(dto.getId())
						.orElseThrow( () -> new EntityNotFoundException());
				
				autor.atualizaDadosDoAutor(dto.getNome(), dto.getEmail(), dto.getDataNascimento(),
						
						dto.getMiniCurriculo());
				
				return modelMapper.map(autor, AutorDto.class);
				
		}

		@Transactional
		public void remover( Long id) {
			
			boolean LivroCadastrado = livroRepository.existsByAutorId(id);
			
			if (LivroCadastrado) {
				
				 throw new RegraDeNegocioException("Autor não pode ser removido. O Mesmo possui livros cadastrados.");
											
			}
			
			this.autorRepository.deleteById(id);
			
		}

		public AutorDto detalhar(Long id) {


				Autor autor = autorRepository.findById(id)
						.orElseThrow( () -> new EntityNotFoundException());
				
				return modelMapper.map(autor, AutorDto.class);
				
				
			
			
			
			
			
		}
		
		
		
	
	
	

}
