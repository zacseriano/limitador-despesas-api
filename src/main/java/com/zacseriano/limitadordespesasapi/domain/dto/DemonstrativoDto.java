package com.zacseriano.limitadordespesasapi.domain.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemonstrativoDto {
	private BigDecimal total;
	private BigDecimal restante;
	private List<EstatisticaDto> estatisticas;
}
