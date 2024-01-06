package com.zacseriano.limitadordespesasapi.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Despesa extends GenericModel {
	private BigDecimal valor;
	private LocalDate dia;
	private TipoDespesa tipoDespesa;
	private MetodoPagamento metodoPagamento;
}