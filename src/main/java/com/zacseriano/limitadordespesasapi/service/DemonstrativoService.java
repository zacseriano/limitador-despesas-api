package com.zacseriano.limitadordespesasapi.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zacseriano.limitadordespesasapi.domain.dto.DemonstrativoDto;
import com.zacseriano.limitadordespesasapi.domain.dto.EstatisticaDto;
import com.zacseriano.limitadordespesasapi.domain.enuns.TipoDemonstrativoEnum;
import com.zacseriano.limitadordespesasapi.domain.model.Despesa;
import com.zacseriano.limitadordespesasapi.domain.model.MetodoPagamento;
import com.zacseriano.limitadordespesasapi.domain.model.TipoDespesa;
import com.zacseriano.limitadordespesasapi.specification.demonstrativo.DemonstrativoFiltro;

@Service
public class DemonstrativoService {
	@Autowired
	private DespesaService despesaService;

	public DemonstrativoDto gerarDemonstrativo(DemonstrativoFiltro filtro){
		List<Despesa> despesas = despesaService.listarDespesasIntervalo(filtro);
		DemonstrativoDto demonstrativo = new DemonstrativoDto(BigDecimal.ZERO, BigDecimal.ZERO, new ArrayList<>());
		if(filtro.getTipo().equals(TipoDemonstrativoEnum.UTILIZACAO)) {
			gerarDemonstrativoUtilizacao(demonstrativo, despesas);
		} else {
			gerarDemonstrativoCobranca(demonstrativo, despesas);
		}		
		
		return demonstrativo;
	}

	private void gerarDemonstrativoCobranca(DemonstrativoDto demonstrativo, List<Despesa> despesas) {
		Map<MetodoPagamento, List<Despesa>> mapaDespesasPorTipo = despesas.stream().collect(Collectors.groupingBy(Despesa::getMetodoPagamento));
		BigDecimal totalGeral = BigDecimal.ZERO;
		for(MetodoPagamento metodoPagamento : mapaDespesasPorTipo.keySet()) {			
			EstatisticaDto estatistica = new EstatisticaDto(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, metodoPagamento.getNome());
			BigDecimal total = mapaDespesasPorTipo.get(metodoPagamento).stream().map(Despesa::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
			estatistica.setTotal(total);
			totalGeral = totalGeral.add(total);
			demonstrativo.getEstatisticas().add(estatistica);
		}
		demonstrativo.setTotal(totalGeral);
		BigDecimal salario = new BigDecimal(5500);
		demonstrativo.setRestante(salario.subtract(totalGeral));		
	}

	private void gerarDemonstrativoUtilizacao(DemonstrativoDto demonstrativo, List<Despesa> despesas) {
		Map<TipoDespesa, List<Despesa>> mapaDespesasPorTipo = despesas.stream().collect(Collectors.groupingBy(Despesa::getTipoDespesa));
		BigDecimal totalGeral = BigDecimal.ZERO;
		for(TipoDespesa tipoDespesa : mapaDespesasPorTipo.keySet()) {
			BigDecimal teto = tipoDespesa.getTeto();
			EstatisticaDto estatistica = new EstatisticaDto(tipoDespesa.getTeto(), BigDecimal.ZERO, BigDecimal.ZERO, tipoDespesa.getNome());
			BigDecimal total = mapaDespesasPorTipo.get(tipoDespesa).stream().map(Despesa::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
			BigDecimal restante = teto.subtract(total);
			estatistica.setTotal(total);
			estatistica.setRestante(restante);
			totalGeral = totalGeral.add(total);
			demonstrativo.getEstatisticas().add(estatistica);
		}
		demonstrativo.setTotal(totalGeral);
		BigDecimal salario = new BigDecimal(5500);
		demonstrativo.setRestante(salario.subtract(totalGeral));		
	}
}
