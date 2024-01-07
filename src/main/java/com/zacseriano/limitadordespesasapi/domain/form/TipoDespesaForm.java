package com.zacseriano.limitadordespesasapi.domain.form;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDespesaForm {
	@NotNull
	private String nome;
	@NotNull
	private BigDecimal teto;
}
