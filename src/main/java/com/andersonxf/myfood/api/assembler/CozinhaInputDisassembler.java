package com.andersonxf.myfood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andersonxf.myfood.api.model.input.CozinhaInput;
import com.andersonxf.myfood.domain.model.Cozinha;

@Component
public class CozinhaInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public Cozinha toDomainObject(CozinhaInput cozinhaInput) {
        return modelMapper.map(cozinhaInput, Cozinha.class);
    }
    
    public void copyToDomainObject(CozinhaInput cozinhaInput, Cozinha cozinha) {
        modelMapper.map(cozinhaInput, cozinha);
    }
    
}       