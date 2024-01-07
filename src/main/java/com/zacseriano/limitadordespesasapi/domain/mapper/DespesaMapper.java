package com.zacseriano.limitadordespesasapi.domain.mapper;

import org.mapstruct.Mapper;

import com.zacseriano.limitadordespesasapi.domain.dto.DespesaDto;
import com.zacseriano.limitadordespesasapi.domain.form.DespesaForm;
import com.zacseriano.limitadordespesasapi.domain.model.Despesa;

@Mapper(componentModel = "spring")
public interface DespesaMapper extends EntityMapper<DespesaDto, Despesa, DespesaForm>{

}
