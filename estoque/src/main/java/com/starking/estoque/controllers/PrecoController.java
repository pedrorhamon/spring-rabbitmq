package com.starking.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.estoque.constantes.RabbitMQConstantes;
import com.starking.estoque.dtos.EstoqueDTO;
import com.starking.estoque.dtos.PrecoDTO;
import com.starking.estoque.services.RabbitMQService;

@RestController
@RequestMapping("preco")
public class PrecoController {
	
	@Autowired
	private RabbitMQService service;
	
	@PutMapping
	private ResponseEntity alteraPreco(@RequestBody PrecoDTO precoDTO) {
		this.service.enviaMensagem(RabbitMQConstantes.FILA_PRECO, precoDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

}
