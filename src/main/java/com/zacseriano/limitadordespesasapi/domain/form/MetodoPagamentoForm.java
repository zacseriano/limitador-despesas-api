package com.zacseriano.limitadordespesasapi.domain.form;

import com.zacseriano.limitadordespesasapi.domain.model.TipoPagamentoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetodoPagamentoForm {
	private TipoPagamentoEnum tipoPagamento;
	private Integer diaLimite;
	private String nome;
}
