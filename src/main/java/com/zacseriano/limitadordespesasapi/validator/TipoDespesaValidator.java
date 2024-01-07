package com.zacseriano.limitadordespesasapi.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zacseriano.limitadordespesasapi.domain.model.TipoDespesa;
import com.zacseriano.limitadordespesasapi.repository.TipoDespesaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoDespesaValidator {
	@Autowired
	private TipoDespesaRepository repository;
	private static final String OBJETO_NAO_ENCONTRADO = "Tipo de Despesa não encontrado.";
	
	public TipoDespesa verificarExistencia(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(OBJETO_NAO_ENCONTRADO));
	}
}
