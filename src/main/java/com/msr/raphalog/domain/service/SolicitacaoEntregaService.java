package com.msr.raphalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msr.raphalog.domain.model.Cliente;
import com.msr.raphalog.domain.model.Entrega;
import com.msr.raphalog.domain.model.StatusEntrega;
import com.msr.raphalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;


@Service @AllArgsConstructor
public class SolicitacaoEntregaService {

	private ClienteService clienteService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {	
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
						
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		return entregaRepository.save(entrega);
	}
	
}
