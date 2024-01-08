package com.zacseriano.limitadordespesasapi.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class GenericSpecification<T> {
    public static Filtro builderFiltro(QueryOperator operador, String chave, Object valor) {
        return Filtro.builder()
                .operador(operador)
                .chave(chave)
                .valor(valor)
                .build();
    }

    public static <T> Specification<T> verificarSpecification(Specification<T> atual, Specification<T> nova, String condicao) {
        if(atual != null) {
            if(condicao.equals("and")) {
                return atual.and(nova);
            } else {
                return atual.or(nova);
            }
        } else {
            return nova;
        }
    }

    protected static <T> Specification<T> criarSpecification(Filtro filtro) {
        switch (filtro.getOperador()) {
            case LESS_THAN_OR_EQUAL:
                return lessThanOrEqualTo(filtro.getChave(), filtro.getValor());
            case GREATER_THAN_OR_EQUAL:
                return greaterThanOrEqualTo(filtro.getChave(), filtro.getValor());
            default:
                throw new RuntimeException("Operação não suportada.");
        }
    }

    private static <T> Specification<T> equals(String key, Object value) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            return builder.equal(root.get(key), value);
        };
    }

    @SuppressWarnings("unchecked")
	private static <T> Specification<T> greaterThan(String key, Object value) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if(value instanceof LocalDate) {
                return builder.greaterThan(root.get(key), (LocalDate) value);
            }

            return ((Specification<T>) gt(key, value)).toPredicate(root, query, builder);
        };
    }

    @SuppressWarnings("unchecked")
	public static <T> Specification<T> greaterThanOrEqualTo(String key, Object value) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            return ((Specification<T>) greaterThan(key, value).or(equals(key, value))).toPredicate(root, query, builder);
        };
    }

    @SuppressWarnings("unchecked")
	private static <T> Specification<T> lessThan(String key, Object value) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if(value instanceof LocalDate) {
                return builder.lessThan(root.get(key), (LocalDate) value);
            }

            return ((Specification<T>) lt(key, value)).toPredicate(root, query, builder);
        };
    }

    @SuppressWarnings("unchecked")
	private static <T> Specification<T> lessThanOrEqualTo(String key, Object value) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            return ((Specification<T>) lessThan(key, value).or(equals(key, value))).toPredicate(root, query, builder);
        };
    }

    private static <T> Specification<T> gt(String key, Object value) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            return builder.gt(root.get(key), (Number) value);
        };
    }

    private static <T> Specification<T> lt(String key, Object value) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            return builder.lt(root.get(key), (Number) value);
        };
    }

}

