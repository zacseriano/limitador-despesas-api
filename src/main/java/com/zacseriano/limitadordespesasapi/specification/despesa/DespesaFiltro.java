package com.zacseriano.limitadordespesasapi.specification.despesa;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DespesaFiltro {
	private Long idTipoDespesa;
	private Long idMetodoPagamento;
	private LocalDate diaInicial; 
	private LocalDate diaFinal; 
	private LocalDate diaCobrancaInicial; 
	private LocalDate diaCobrancaFinal;
}
