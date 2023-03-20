package com.msr.raphalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.msr.raphalog.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

//DTO
@Getter @Setter
public class EntregaModel {

	private Integer id;
	private String nomeCliente;
	private DestinatarioModel destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
}
