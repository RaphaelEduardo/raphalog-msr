package com.msr.raphalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.msr.raphalog.api.assembler.EntregaAssembler;
import com.msr.raphalog.api.model.EntregaModel;
import com.msr.raphalog.api.model.input.EntregaInput;
import com.msr.raphalog.domain.model.Entrega;
import com.msr.raphalog.domain.repository.EntregaRepository;
import com.msr.raphalog.domain.service.FinalizacaoEntregaService;
import com.msr.raphalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController 
@RequestMapping("/entregas") 
public class EntregaController {

	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private FinalizacaoEntregaService finalizacaoEntregaService;
	private EntregaAssembler entregaAssembler;
	
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		return entregaAssembler.toModel(entregaSolicitada);
	}
	
	@GetMapping
	public List<EntregaModel> listar() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Integer entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
						.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/entregas/{entregaId}/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Integer entregaId) {
		 finalizacaoEntregaService.finalizar(entregaId);
	}
	
}
