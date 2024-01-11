package com.zacseriano.limitadordespesasapi.specification.demonstrativo;

import java.time.LocalDate;

import com.zacseriano.limitadordespesasapi.domain.enuns.TipoDemonstrativoEnum;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemonstrativoFiltro {
	@NotNull
	private LocalDate diaInicio;
	@NotNull
	private LocalDate diaFim;
	@NotNull
	private TipoDemonstrativoEnum tipo;
}
