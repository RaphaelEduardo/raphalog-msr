package com.msr.raphalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.msr.raphalog.api.assembler.OcorrenciaAssembler;
import com.msr.raphalog.api.model.OcorrenciaModel;
import com.msr.raphalog.api.model.input.OcorrenciaInput;
import com.msr.raphalog.domain.model.Entrega;
import com.msr.raphalog.domain.model.Ocorrencia;
import com.msr.raphalog.domain.service.BuscaEntregaService;
import com.msr.raphalog.domain.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	private BuscaEntregaService buscaEntregaService;
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	
	@PostMapping @ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Integer entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.
				registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Integer entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
	
}
