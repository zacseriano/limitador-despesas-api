package com.zacseriano.limitadordespesasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zacseriano.limitadordespesasapi.domain.dto.DemonstrativoDto;
import com.zacseriano.limitadordespesasapi.service.DemonstrativoService;
import com.zacseriano.limitadordespesasapi.specification.demonstrativo.DemonstrativoFiltro;

@RequestMapping("/demonstrativo")
@RestController
public class DemonstrativoController {
	@Autowired
	private DemonstrativoService service;
	
	@GetMapping
	public ResponseEntity<DemonstrativoDto> gerarDemonstrativoUtilizacao(DemonstrativoFiltro filtro) {
		return ResponseEntity.ok().body(service.gerarDemonstrativo(filtro));
	}
	
}
