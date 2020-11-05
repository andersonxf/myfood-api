package com.andersonxf.myfood.domain.repository;

import java.util.List;

import com.andersonxf.myfood.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);
	
}