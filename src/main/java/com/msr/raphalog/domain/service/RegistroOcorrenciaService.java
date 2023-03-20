package com.msr.raphalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msr.raphalog.domain.model.Entrega;
import com.msr.raphalog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Integer entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}
	
}
