package com.msr.raphalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msr.raphalog.domain.exception.NegocioException;
import com.msr.raphalog.domain.model.Cliente;
import com.msr.raphalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class ClienteService {

	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado!"));
		
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail.");
		}
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}
	
}
