package com.zacseriano.limitadordespesasapi.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.zacseriano.limitadordespesasapi.domain.dto.DespesaDto;
import com.zacseriano.limitadordespesasapi.domain.form.DespesaForm;
import com.zacseriano.limitadordespesasapi.domain.model.Despesa;

@Mapper(componentModel = "spring")
public interface DespesaMapper extends EntityMapper<DespesaDto, Despesa, DespesaForm>{
	@Mappings({
		@Mapping(target = "tipoDespesa",source = "tipoDespesa.nome"),
		@Mapping(target = "metodoPagamento",source = "metodoPagamento.nome")
	})
	DespesaDto toDto(Despesa entity);
	@Mappings({
		@Mapping(target = "tipoDespesa", ignore = true),
		@Mapping(target = "metodoPagamento", ignore = true)
	})
	Despesa toModel(DespesaForm form);
}
