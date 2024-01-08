package com.zacseriano.limitadordespesasapi.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DespesaDto {
	private Long id;
	private BigDecimal valor;
	private LocalDate dia;
	private LocalDate diaCobranca;
	private String tipoDespesa;
	private String metodoPagamento;
}
