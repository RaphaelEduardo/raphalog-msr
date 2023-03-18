package com.msr.raphalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msr.raphalog.domain.model.Cliente;

@RestController
public class ClienteController {

	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		// "from Cliente" é uma JPQL é uma linguagem de consultas do Jarkarta Persistence (parecida com o SQL, mas para consultar no modelo OO).
		return manager.createQuery("from Cliente", Cliente.class)
				.getResultList(); // Retorna uma lista de Cliente
	}
	
	
	
}
