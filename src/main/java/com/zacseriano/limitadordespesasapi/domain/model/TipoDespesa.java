package com.zacseriano.limitadordespesasapi.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TipoDespesa extends GenericModel {
	private String nome;
	private BigDecimal teto;
}
