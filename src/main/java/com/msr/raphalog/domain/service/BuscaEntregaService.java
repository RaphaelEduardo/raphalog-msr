package com.msr.raphalog.domain.service;

import org.springframework.stereotype.Service;

import com.msr.raphalog.domain.exception.EntidadeNaoEncontradaException;
import com.msr.raphalog.domain.model.Entrega;
import com.msr.raphalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Integer entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	
}
