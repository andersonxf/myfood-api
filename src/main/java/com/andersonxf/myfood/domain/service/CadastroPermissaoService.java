package com.andersonxf.myfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonxf.myfood.domain.exception.PermissaoNaoEncontradaException;
import com.andersonxf.myfood.domain.model.Permissao;
import com.andersonxf.myfood.domain.repository.PermissaoRepository;

@Service
public class CadastroPermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;
    
    public Permissao buscarOuFalhar(Long permissaoId) {
        return permissaoRepository.findById(permissaoId)
            .orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId));
    }
}