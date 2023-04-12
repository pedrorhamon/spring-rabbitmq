package com.starking.estoque.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.estoque.dtos.EstoqueDTO;

@RestController
@RequestMapping("estoque")
public class EstoqueController {
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDTO) {
		return new ResponseEntity(HttpStatus.OK);
	}

}
