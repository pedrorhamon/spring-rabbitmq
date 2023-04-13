package com.starking.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.estoque.services.RabbitMQService;

import constantes.RabbitmqConstantes;
import dto.EstoqueDto;

@RestController
@RequestMapping("estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitMQService service;
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDTO) {
		this.service.enviaMensagem(RabbitmqConstantes.FILA_ESTOQUE, estoqueDTO);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
