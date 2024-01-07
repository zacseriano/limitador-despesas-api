package com.zacseriano.limitadordespesasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zacseriano.limitadordespesasapi.domain.dto.TipoDespesaDto;
import com.zacseriano.limitadordespesasapi.domain.form.TipoDespesaForm;
import com.zacseriano.limitadordespesasapi.service.TipoDespesaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/tipo-despesa")
public class TipoDespesaController {
	@Autowired
	private TipoDespesaService service;
	
	@GetMapping
	public ResponseEntity<Page<TipoDespesaDto>> listar(@PageableDefault(page = 0, size = 5) Pageable paginacao){
		return ResponseEntity.ok(service.listar(paginacao));
	}
	
	@PostMapping
	public ResponseEntity<TipoDespesaDto> cadastrar(@RequestBody @Valid TipoDespesaForm form){
		return ResponseEntity.ok(service.cadastrar(form));
	}
}
