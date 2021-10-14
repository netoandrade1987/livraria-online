package br.com.alura.livrariaonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaonline.dto.QuantidadeDeLivroPorAutorDto;
import br.com.alura.livrariaonline.repository.LivroRepository;

@Service
public class RelatorioService {

	@Autowired
	private LivroRepository repository;

	public List<QuantidadeDeLivroPorAutorDto> relatorioQuantidadeDeLivroPorAutor() {

		return repository.quantidadeDeLivroPorAutorDto();

	}

}
