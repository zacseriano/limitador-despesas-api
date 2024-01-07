package com.zacseriano.limitadordespesasapi.domain.form;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDespesaForm {
	private String nome;
	private BigDecimal teto;
}
