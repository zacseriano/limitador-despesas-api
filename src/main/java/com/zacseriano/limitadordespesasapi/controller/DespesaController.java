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

import com.zacseriano.limitadordespesasapi.domain.dto.DespesaDto;
import com.zacseriano.limitadordespesasapi.domain.form.DespesaForm;
import com.zacseriano.limitadordespesasapi.service.DespesaService;
import com.zacseriano.limitadordespesasapi.specification.despesa.DespesaFiltro;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/despesa")
public class DespesaController {
	@Autowired
	private DespesaService service;
	
	@GetMapping
	public ResponseEntity<Page<DespesaDto>> listar(DespesaFiltro filtro, @PageableDefault(page = 0, size = 5) Pageable paginacao){
		return ResponseEntity.ok(service.listar(filtro, paginacao));
	}
	
	@PostMapping
	public ResponseEntity<DespesaDto> cadastrar(@RequestBody @Valid DespesaForm form){
		return ResponseEntity.ok(service.cadastrar(form));
	}
}
