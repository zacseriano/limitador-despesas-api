package com.zacseriano.limitadordespesasapi.domain.mapper;

import java.util.List;

public interface EntityMapper<D, E, F> {
    E toModel(F form);
    D toDto(E entity);    
    List<D> toDto(List<E> entityList);
}
