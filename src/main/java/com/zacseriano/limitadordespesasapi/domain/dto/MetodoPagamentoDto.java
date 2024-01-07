package com.zacseriano.limitadordespesasapi.domain.dto;

import com.zacseriano.limitadordespesasapi.domain.model.TipoPagamentoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetodoPagamentoDto {
	private Long id;
	private TipoPagamentoEnum tipoPagamento;
	private Integer diaLimite;
	private String nome;
}
