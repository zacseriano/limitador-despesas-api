package com.zacseriano.limitadordespesasapi.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zacseriano.limitadordespesasapi.domain.model.MetodoPagamento;
import com.zacseriano.limitadordespesasapi.repository.MetodoPagamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MetodoPagamentoValidator {
	@Autowired
	private MetodoPagamentoRepository repository;
	private static final String OBJETO_NAO_ENCONTRADO = "Método de Pagamento não encontrado.";
	
	public MetodoPagamento verificarExistencia(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(OBJETO_NAO_ENCONTRADO));
	}
}
