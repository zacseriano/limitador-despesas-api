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

import com.zacseriano.limitadordespesasapi.domain.dto.MetodoPagamentoDto;
import com.zacseriano.limitadordespesasapi.domain.form.MetodoPagamentoForm;
import com.zacseriano.limitadordespesasapi.service.MetodoPagamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/metodo-pagamento")
public class MetodoPagamentoController {
	@Autowired
	private MetodoPagamentoService service;
	
	@GetMapping
	public ResponseEntity<Page<MetodoPagamentoDto>> listar(@PageableDefault(page = 0, size = 5) Pageable paginacao){
		return ResponseEntity.ok(service.listar(paginacao));
	}
	
	@PostMapping
	public ResponseEntity<MetodoPagamentoDto> cadastrar(@RequestBody @Valid MetodoPagamentoForm form){
		return ResponseEntity.ok(service.cadastrar(form));
	}
}
