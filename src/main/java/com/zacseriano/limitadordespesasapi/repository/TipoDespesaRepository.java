package com.zacseriano.limitadordespesasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zacseriano.limitadordespesasapi.domain.model.TipoDespesa;

public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long>, JpaSpecificationExecutor<TipoDespesa> {

}