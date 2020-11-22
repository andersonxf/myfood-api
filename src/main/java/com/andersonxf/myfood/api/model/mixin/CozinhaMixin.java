package com.andersonxf.myfood.api.model.mixin;

import java.util.List;

import com.andersonxf.myfood.domain.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class CozinhaMixin {

	@JsonIgnore
	private List<Restaurante> restaurantes;
	
}