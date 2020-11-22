package com.andersonxf.myfood.api.model.mixin;

import java.time.OffsetDateTime;
import java.util.List;

import com.andersonxf.myfood.domain.model.Cozinha;
import com.andersonxf.myfood.domain.model.Endereco;
import com.andersonxf.myfood.domain.model.FormaPagamento;
import com.andersonxf.myfood.domain.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public abstract class RestauranteMixin {

	@JsonIgnoreProperties(value = "nome", allowGetters = true)
	private Cozinha cozinha;
	
	@JsonIgnore
	private Endereco endereco;
	
	@JsonIgnore
	private OffsetDateTime dataCadastro;
	
	@JsonIgnore
	private OffsetDateTime dataAtualizacao;
	
	@JsonIgnore
	private List<FormaPagamento> formasPagamento;
	
	@JsonIgnore
	private List<Produto> produtos;
	
}