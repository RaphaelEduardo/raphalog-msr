package com.msr.raphalog.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.msr.raphalog.domain.model.Entrega;
import com.msr.raphalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@RestController @RequestMapping("/entregas") @AllArgsConstructor
public class EntregaController {

	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@PostMapping @ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}
	
}
