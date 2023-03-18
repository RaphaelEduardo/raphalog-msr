package com.msr.raphalog.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msr.raphalog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
	List<Cliente> findByNome(String nome); //retorna por nome
	List<Cliente> findByNomeContaining(String nome); // retorna por caracteres contidos no nome
	
	
}
