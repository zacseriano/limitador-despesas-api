package com.zacseriano.limitadordespesasapi.domain.mapper;

import org.mapstruct.Mapper;

import com.zacseriano.limitadordespesasapi.domain.dto.MetodoPagamentoDto;
import com.zacseriano.limitadordespesasapi.domain.form.MetodoPagamentoForm;
import com.zacseriano.limitadordespesasapi.domain.model.MetodoPagamento;

@Mapper(componentModel = "spring")
public interface MetodoPagamentoMapper extends EntityMapper<MetodoPagamentoDto, MetodoPagamento, MetodoPagamentoForm> {

}
