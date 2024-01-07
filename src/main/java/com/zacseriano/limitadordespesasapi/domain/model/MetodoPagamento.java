package com.zacseriano.limitadordespesasapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MetodoPagamento extends GenericModel {
	@Enumerated(EnumType.STRING)
	private TipoPagamentoEnum tipoPagamento;
	private Integer diaLimite;
	private String nome;
}
