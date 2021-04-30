package br.com.isidrocorp.eventdash.dto;

public class EventoPorEquipamento {
	private long qtdEventos;
	private String nomeEquipamento;
	
	
	public EventoPorEquipamento(long qtdEventos, String nomeEquipamento) {
		super();
		this.qtdEventos = qtdEventos;
		this.nomeEquipamento = nomeEquipamento;
	}
	
	public long getQtdEventos() {
		return qtdEventos;
	}
	public void setQtdEventos(long qtdEventos) {
		this.qtdEventos = qtdEventos;
	}
	public String getNomeEquipamento() {
		return nomeEquipamento;
	}
	public void setNomeEquipamento(String nomeEvento) {
		this.nomeEquipamento = nomeEvento;
	}
}
