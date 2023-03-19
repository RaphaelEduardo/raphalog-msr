package com.msr.raphalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msr.raphalog.domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer>{
	
}
