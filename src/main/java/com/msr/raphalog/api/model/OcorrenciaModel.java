package com.msr.raphalog.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OcorrenciaModel {

	private Integer id;
	private String descricao;
	private OffsetDateTime dataRegistro;
	
}
