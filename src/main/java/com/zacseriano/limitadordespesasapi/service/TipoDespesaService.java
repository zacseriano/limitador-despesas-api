package com.zacseriano.limitadordespesasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zacseriano.limitadordespesasapi.domain.dto.TipoDespesaDto;
import com.zacseriano.limitadordespesasapi.domain.form.TipoDespesaForm;
import com.zacseriano.limitadordespesasapi.domain.mapper.TipoDespesaMapper;
import com.zacseriano.limitadordespesasapi.domain.model.TipoDespesa;
import com.zacseriano.limitadordespesasapi.repository.TipoDespesaRepository;

import jakarta.validation.Valid;

@Service
public class TipoDespesaService {
	@Autowired
	private TipoDespesaRepository repository;
	@Autowired
	private TipoDespesaMapper mapper;
	
	public Page<TipoDespesaDto> listar(Pageable paginacao) {
		return repository.findAll(paginacao).map(mapper::toDto);
	}

	public TipoDespesaDto cadastrar(@Valid TipoDespesaForm form) {
		TipoDespesa novoTipoDespesa = mapper.toModel(form);
		novoTipoDespesa = repository.save(novoTipoDespesa);
		return mapper.toDto(novoTipoDespesa);
	}

}
