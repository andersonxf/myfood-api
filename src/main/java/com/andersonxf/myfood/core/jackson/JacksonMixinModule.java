package com.andersonxf.myfood.core.jackson;

import org.springframework.stereotype.Component;

import com.andersonxf.myfood.api.model.mixin.CidadeMixin;
import com.andersonxf.myfood.api.model.mixin.CozinhaMixin;
import com.andersonxf.myfood.domain.model.Cidade;
import com.andersonxf.myfood.domain.model.Cozinha;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonMixinModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public JacksonMixinModule() {
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
	}
	
}