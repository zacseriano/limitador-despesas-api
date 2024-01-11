package com.zacseriano.limitadordespesasapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zacseriano.limitadordespesasapi.domain.dto.DespesaDto;
import com.zacseriano.limitadordespesasapi.domain.enuns.TipoDemonstrativoEnum;
import com.zacseriano.limitadordespesasapi.domain.form.DespesaForm;
import com.zacseriano.limitadordespesasapi.domain.mapper.DespesaMapper;
import com.zacseriano.limitadordespesasapi.domain.model.Despesa;
import com.zacseriano.limitadordespesasapi.domain.model.MetodoPagamento;
import com.zacseriano.limitadordespesasapi.domain.model.TipoDespesa;
import com.zacseriano.limitadordespesasapi.domain.model.TipoPagamentoEnum;
import com.zacseriano.limitadordespesasapi.repository.DespesaRepository;
import com.zacseriano.limitadordespesasapi.specification.demonstrativo.DemonstrativoFiltro;
import com.zacseriano.limitadordespesasapi.specification.despesa.DespesaFiltro;
import com.zacseriano.limitadordespesasapi.specification.despesa.DespesaSpecificationBuilder;
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

	public Page<DespesaDto> listar(DespesaFiltro filtro, Pageable paginacao) {
		Specification<Despesa> spec  = DespesaSpecificationBuilder.builder(filtro);
		return repository.findAll(spec, paginacao).map(mapper::toDto);
	}
	
	public List<Despesa> listarDespesasIntervalo(DemonstrativoFiltro filtro){
		DespesaFiltro filtroDespesa = new DespesaFiltro();
		if(filtro.getTipo().equals(TipoDemonstrativoEnum.UTILIZACAO)) {
			filtroDespesa.setDiaInicial(filtro.getDiaInicio());
			filtroDespesa.setDiaFinal(filtro.getDiaFim());
		} else {
			filtroDespesa.setDiaCobrancaInicial(filtro.getDiaInicio());
			filtroDespesa.setDiaCobrancaFinal(filtro.getDiaFim());
		}
		Specification<Despesa> spec = DespesaSpecificationBuilder.builder(filtroDespesa);
		return repository.findAll(spec);
	}

	public DespesaDto cadastrar(@Valid DespesaForm form) {
		Despesa despesa = mapper.toModel(form);
		TipoDespesa tipoDespesa = tipoDespesaValidator.verificarExistencia(form.getIdTipoDespesa());
		MetodoPagamento metodoPagamento = metodoPagamentoValidator.verificarExistencia(form.getIdMetodoPagamento());
		despesa.setTipoDespesa(tipoDespesa);
		despesa.setMetodoPagamento(metodoPagamento);
		despesa.setDiaCobranca(validarDiaCobranca(despesa));
		despesa = repository.save(despesa);
		return mapper.toDto(despesa);
	}
	
	private LocalDate validarDiaCobranca(Despesa despesa) {
		if(despesa.getMetodoPagamento().getTipoPagamento().equals(TipoPagamentoEnum.DEBITO)) {
			return despesa.getDia();
		}
		LocalDate diaDespesa = despesa.getDia();
		LocalDate diaCobranca = diaDespesa.withDayOfMonth(despesa.getMetodoPagamento().getDiaLimite()).plusDays(8);
		if(diaDespesa.getDayOfMonth() > despesa.getMetodoPagamento().getDiaLimite()) {
			diaCobranca = diaCobranca.plusMonths(1);
		}
		return diaCobranca;
	}

}