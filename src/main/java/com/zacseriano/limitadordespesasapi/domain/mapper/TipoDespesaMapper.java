package com.zacseriano.limitadordespesasapi.domain.mapper;

import org.mapstruct.Mapper;

import com.zacseriano.limitadordespesasapi.domain.dto.TipoDespesaDto;
import com.zacseriano.limitadordespesasapi.domain.form.TipoDespesaForm;
import com.zacseriano.limitadordespesasapi.domain.model.TipoDespesa;

@Mapper(componentModel = "spring")
public interface TipoDespesaMapper extends EntityMapper<TipoDespesaDto, TipoDespesa, TipoDespesaForm>{
	
}
