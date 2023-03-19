package com.msr.raphalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonInclude(Include.NON_NULL)
public class Problema {

	private Integer Status;
	private LocalDateTime dataHora;
	private String titulo; 
	private List<Campo> campo;
	
}