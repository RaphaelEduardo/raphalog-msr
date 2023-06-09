package com.msr.raphalog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonInclude(Include.NON_NULL)
public class Problema {

	private Integer Status;
	private OffsetDateTime dataHora;
	private String titulo; 
	private List<Campo> campo;
	
}
