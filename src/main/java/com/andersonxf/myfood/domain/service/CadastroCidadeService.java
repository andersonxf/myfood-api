package com.andersonxf.myfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.andersonxf.myfood.domain.exception.EntidadeEmUsoException;
import com.andersonxf.myfood.domain.exception.EntidadeNaoEncontradaException;
import com.andersonxf.myfood.domain.model.Cidade;
import com.andersonxf.myfood.domain.model.Estado;
import com.andersonxf.myfood.domain.repository.CidadeRepository;
import com.andersonxf.myfood.domain.repository.EstadoRepository;

public class CadastroCidadeService {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de estado com código %d ", estadoId)));
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com código %d", estadoId));
		}
		
		cidade.setEstado(estado);
		
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe uma cadastro de cidade com código %d", cidadeId));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
		}
	}

}

