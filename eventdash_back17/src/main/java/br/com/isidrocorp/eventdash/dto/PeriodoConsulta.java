package br.com.isidrocorp.eventdash.dto;

import java.time.LocalDate;

public class PeriodoConsulta {
	private LocalDate inicio;
	private LocalDate fim;
	
	
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
}
