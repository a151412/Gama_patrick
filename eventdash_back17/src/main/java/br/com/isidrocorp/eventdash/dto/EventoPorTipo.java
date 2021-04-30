package br.com.isidrocorp.eventdash.dto;

public class EventoPorTipo {
	private long qtdEventos;
	private String nomeEvento;
	
	public EventoPorTipo(long qtdEventos, String nomeEvento) {
		super();
		this.qtdEventos = qtdEventos;
		this.nomeEvento = nomeEvento;
	}
	
	public long getQtdEventos() {
		return qtdEventos;
	}
	public void setQtdEventos(long qtdEventos) {
		this.qtdEventos = qtdEventos;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	
}
