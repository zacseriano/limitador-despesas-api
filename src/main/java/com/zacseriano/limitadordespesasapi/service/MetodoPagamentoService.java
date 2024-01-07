package com.zacseriano.limitadordespesasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zacseriano.limitadordespesasapi.domain.dto.MetodoPagamentoDto;
import com.zacseriano.limitadordespesasapi.domain.form.MetodoPagamentoForm;
import com.zacseriano.limitadordespesasapi.domain.mapper.MetodoPagamentoMapper;
import com.zacseriano.limitadordespesasapi.domain.model.MetodoPagamento;
import com.zacseriano.limitadordespesasapi.repository.MetodoPagamentoRepository;

@Service
public class MetodoPagamentoService {
	@Autowired
	private MetodoPagamentoRepository repository;
	@Autowired
	private MetodoPagamentoMapper mapper;
	
	public Page<MetodoPagamentoDto> listar(Pageable paginacao){
		return repository.findAll(paginacao).map(mapper::toDto);
	}
	
	public MetodoPagamentoDto cadastrar(MetodoPagamentoForm form) {
		MetodoPagamento novoMetodo = mapper.toModel(form);
		novoMetodo = repository.save(novoMetodo);
		return mapper.toDto(novoMetodo);
	}
}
