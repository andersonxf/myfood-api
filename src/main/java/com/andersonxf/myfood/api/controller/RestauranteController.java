package com.andersonxf.myfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonxf.myfood.domain.exception.EntidadeNaoEncontradaException;
import com.andersonxf.myfood.domain.model.Restaurante;
import com.andersonxf.myfood.domain.repository.RestauranteRepository;
import com.andersonxf.myfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping(value = "restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.listar();
	}
	@GetMapping
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		
		if ( restaurante != null) {
			return ResponseEntity.ok(restaurante);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestauranteService.salvar(restaurante);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
				
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> alterar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		try {
			Restaurante restaurandeAtual = restauranteRepository.buscar(restauranteId);
			
			if(restaurandeAtual != null) {
				BeanUtils.copyProperties(restaurante, restaurandeAtual, "id");
				
				restaurandeAtual = cadastroRestauranteService.salvar(restaurandeAtual);
				return ResponseEntity.ok(restaurandeAtual);
				
			}
		
			return ResponseEntity.notFound().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}

}