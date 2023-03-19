package com.msr.raphalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Problema {

	private Integer Status;
	private LocalDateTime dataHora;
	private String titulo; 
	private List<Campo> campo;
	
}
