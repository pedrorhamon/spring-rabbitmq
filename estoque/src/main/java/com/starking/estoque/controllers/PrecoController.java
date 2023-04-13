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
import dto.PrecoDto;

@RestController
@RequestMapping("preco")
public class PrecoController {
	
	@Autowired
	private RabbitMQService service;
	
	@PutMapping
	private ResponseEntity alteraPreco(@RequestBody PrecoDto precoDTO) {
		this.service.enviaMensagem(RabbitmqConstantes.FILA_PRECO, precoDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

}
