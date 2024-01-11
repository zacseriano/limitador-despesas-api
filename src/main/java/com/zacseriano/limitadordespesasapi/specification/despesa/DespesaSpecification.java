package com.zacseriano.limitadordespesasapi.specification.despesa;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.zacseriano.limitadordespesasapi.domain.model.Despesa;
import com.zacseriano.limitadordespesasapi.domain.model.MetodoPagamento;
import com.zacseriano.limitadordespesasapi.domain.model.TipoDespesa;
import com.zacseriano.limitadordespesasapi.specification.GenericSpecification;
import com.zacseriano.limitadordespesasapi.specification.QueryOperator;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public class DespesaSpecification extends GenericSpecification<Despesa>{
    protected static Specification<Despesa> idTipoDespesa(Long idTipoDespesa) {
        return (Root<Despesa> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<Despesa, TipoDespesa> join = root.join("tipoDespesa");
            query.distinct(true);
            return builder.equal(join.get("id"), idTipoDespesa);
        };
    }
    
    protected static Specification<Despesa> idMetodoPagamento(Long idMetodoPagamento) {
        return (Root<Despesa> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Join<Despesa, MetodoPagamento> join = root.join("metodoPagamento");
            query.distinct(true);
            return builder.equal(join.get("id"), idMetodoPagamento);
        };
    }
    
    protected static Specification<Despesa> diaInicial(LocalDate diaInicial) {
        return criarSpecification(builderFiltro(QueryOperator.GREATER_THAN_OR_EQUAL, "dia", diaInicial));
    }
    
    protected static Specification<Despesa> diaFinal(LocalDate diaFinal) {
        return criarSpecification(builderFiltro(QueryOperator.LESS_THAN, "dia", diaFinal));
    }
    
    protected static Specification<Despesa> diaCobrancaInicial(LocalDate diaCobrancaInicial) {
        return criarSpecification(builderFiltro(QueryOperator.GREATER_THAN_OR_EQUAL, "diaCobranca", diaCobrancaInicial));
    }
    
    protected static Specification<Despesa> diaCobrancaFinal(LocalDate diaCobrancaFinal) {
        return criarSpecification(builderFiltro(QueryOperator.LESS_THAN, "diaCobranca", diaCobrancaFinal));
    }
}
