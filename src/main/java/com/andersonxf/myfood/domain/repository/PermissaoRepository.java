package com.andersonxf.myfood.domain.repository;

import java.util.List;

import com.andersonxf.myfood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();
	Permissao buscar(Long id);
	Permissao salvar(Permissao permissao);
	void remover(Permissao permissao);
	
}
