package com.zacseriano.limitadordespesasapi.domain.form;

import com.zacseriano.limitadordespesasapi.domain.model.TipoPagamentoEnum;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetodoPagamentoForm {
	@NotNull
	private TipoPagamentoEnum tipoPagamento;
	@NotNull
	private Integer diaLimite;
	@NotNull
	private String nome;
}
