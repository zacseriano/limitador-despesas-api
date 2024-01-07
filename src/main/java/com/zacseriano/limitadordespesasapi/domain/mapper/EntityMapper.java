package com.zacseriano.limitadordespesasapi.domain.mapper;

public interface EntityMapper<D, E, F> {
    E toModel(F form);
    D toDto(E entity);
}
