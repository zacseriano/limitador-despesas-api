package com.zacseriano.limitadordespesasapi.specification.despesa;

import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;
import com.zacseriano.limitadordespesasapi.domain.model.Despesa;

public class DespesaSpecificationBuilder {
	public static Specification<Despesa> builder(DespesaFiltro filtro) {
        Specification<Despesa> specification = idTipoDespesa(filtro.getIdTipoDespesa(), null);
        specification = idMetodoPagamento(filtro.getIdMetodoPagamento(), specification);
        specification = diaInicial(filtro.getDiaInicial(), specification);
        specification = diaFinal(filtro.getDiaFinal(), specification);
        specification = diaCobrancaInicial(filtro.getDiaCobrancaInicial(), specification);
        specification = diaCobrancaFinal(filtro.getDiaCobrancaFinal(), specification);

        return specification;
    }

    private static Specification<Despesa> idTipoDespesa(Long idTipoDespesa, Specification<Despesa> specification) {
        if(idTipoDespesa != null) {
            return DespesaSpecification.verificarSpecification(specification, DespesaSpecification.idTipoDespesa(idTipoDespesa), "and");
        }
        return specification;
    }
    
    private static Specification<Despesa> idMetodoPagamento(Long idMetodoPagamento, Specification<Despesa> specification) {
        if(idMetodoPagamento != null) {
            return DespesaSpecification.verificarSpecification(specification, DespesaSpecification.idMetodoPagamento(idMetodoPagamento), "and");
        }
        return specification;
    }
    
    private static Specification<Despesa> diaInicial(LocalDate diaInicial, Specification<Despesa> specification) {
        if(diaInicial != null) {
            return DespesaSpecification.verificarSpecification(specification, DespesaSpecification.diaInicial(diaInicial), "and");
        }
        return specification;
    }
    
    private static Specification<Despesa> diaFinal(LocalDate diaFinal, Specification<Despesa> specification) {
        if(diaFinal != null) {
            return DespesaSpecification.verificarSpecification(specification, DespesaSpecification.diaFinal(diaFinal), "and");
        }
        return specification;
    }
    
    private static Specification<Despesa> diaCobrancaInicial(LocalDate diaCobrancaInicial, Specification<Despesa> specification) {
        if(diaCobrancaInicial != null) {
            return DespesaSpecification.verificarSpecification(specification, DespesaSpecification.diaCobrancaInicial(diaCobrancaInicial), "and");
        }
        return specification;
    }
    
    private static Specification<Despesa> diaCobrancaFinal(LocalDate diaCobrancaFinal, Specification<Despesa> specification) {
        if(diaCobrancaFinal != null) {
            return DespesaSpecification.verificarSpecification(specification, DespesaSpecification.diaCobrancaFinal(diaCobrancaFinal), "and");
        }
        return specification;
    }
    

    
}
