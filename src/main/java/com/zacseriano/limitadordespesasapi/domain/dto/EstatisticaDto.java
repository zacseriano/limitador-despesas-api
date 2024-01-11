package com.zacseriano.limitadordespesasapi.domain.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticaDto {
	private BigDecimal teto;
	private BigDecimal total;	
	private BigDecimal restante;
	private String tipo;
}