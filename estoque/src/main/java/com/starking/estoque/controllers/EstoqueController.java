package com.starking.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.estoque.services.RabbitMQService;
import com.starking.librabbitmq.constantes.RabbitMQConstantes;
import com.starking.librabbitmq.dtos.EstoqueDTO;

@RestController
@RequestMapping("estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitMQService service;
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDTO) {
		this.service.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDTO);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
