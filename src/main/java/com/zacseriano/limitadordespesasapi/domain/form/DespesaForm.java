package com.zacseriano.limitadordespesasapi.domain.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DespesaForm {
	private BigDecimal valor;
	private LocalDate dia;
	private Long idTipoDespesa;
	private Long idMetodoPagamento;
}