package com.zacseriano.limitadordespesasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zacseriano.limitadordespesasapi.domain.dto.DespesaDto;
import com.zacseriano.limitadordespesasapi.domain.form.DespesaForm;
import com.zacseriano.limitadordespesasapi.domain.mapper.DespesaMapper;
import com.zacseriano.limitadordespesasapi.domain.model.Despesa;
import com.zacseriano.limitadordespesasapi.domain.model.MetodoPagamento;
import com.zacseriano.limitadordespesasapi.domain.model.TipoDespesa;
import com.zacseriano.limitadordespesasapi.repository.DespesaRepository;
import com.zacseriano.limitadordespesasapi.validator.MetodoPagamentoValidator;
import com.zacseriano.limitadordespesasapi.validator.TipoDespesaValidator;

import jakarta.validation.Valid;

@Service
public class DespesaService {
	@Autowired
	private DespesaRepository repository;
	@Autowired
	private DespesaMapper mapper;
	@Autowired
	private TipoDespesaValidator tipoDespesaValidator;
	@Autowired
	private MetodoPagamentoValidator metodoPagamentoValidator;

	public Page<DespesaDto> listar(Pageable paginacao) {
		return repository.findAll(paginacao).map(mapper::toDto);
	}

	public DespesaDto cadastrar(@Valid DespesaForm form) {
		Despesa despesa = mapper.toModel(form);
		TipoDespesa tipoDespesa = tipoDespesaValidator.verificarExistencia(form.getIdTipoDespesa());
		MetodoPagamento metodoPagamento = metodoPagamentoValidator.verificarExistencia(form.getIdMetodoPagamento());
		despesa.setTipoDespesa(tipoDespesa);
		despesa.setMetodoPagamento(metodoPagamento);
		despesa = repository.save(despesa);
		return mapper.toDto(despesa);
	}

}