package com.zacseriano.limitadordespesasapi.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDespesaDto {
	private String nome;
	private BigDecimal teto;
}
