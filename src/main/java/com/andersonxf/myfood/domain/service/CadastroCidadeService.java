package com.andersonxf.myfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.andersonxf.myfood.domain.exception.CidadeNaoEncontradaException;
import com.andersonxf.myfood.domain.exception.EntidadeEmUsoException;
import com.andersonxf.myfood.domain.exception.EntidadeNaoEncontradaException;
import com.andersonxf.myfood.domain.model.Cidade;
import com.andersonxf.myfood.domain.model.Estado;
import com.andersonxf.myfood.domain.repository.CidadeRepository;
import com.andersonxf.myfood.domain.repository.EstadoRepository;

public class CadastroCidadeService {
	private static final String MSG_CIDADE_EM_USO = "Cidade de código %d não pode ser removida, pois está em uso";

	private static final String MSG_CIDADE_NAO_ENCONTRADA = "Não existe uma cadastro de cidade com código %d";

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException(
						String.format(MSG_CIDADE_NAO_ENCONTRADA, estadoId)));
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_CIDADE_NAO_ENCONTRADA, estadoId));
		}
		
		cidade.setEstado(estado);
		
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new CidadeNaoEncontradaException(cidadeId);
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_CIDADE_EM_USO, cidadeId));
		}
	}
	
	public Cidade buscarOuFalhar(Long cidadeId) {
		return cidadeRepository.findById(cidadeId)
			.orElseThrow(() -> new CidadeNaoEncontradaException(cidadeId));
	}

}

