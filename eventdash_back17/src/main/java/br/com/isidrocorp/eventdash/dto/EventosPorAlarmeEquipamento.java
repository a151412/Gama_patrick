package br.com.isidrocorp.eventdash.dto;

public class EventosPorAlarmeEquipamento {
	private long qtdEventos;
	private String nomeAlarme;
	private String nomeEquipamento;
	
	public EventosPorAlarmeEquipamento(long qtdEventos, String nomeAlarme, String nomeEquipamento) {
		super();
		this.qtdEventos = qtdEventos;
		this.nomeAlarme = nomeAlarme;
		this.nomeEquipamento = nomeEquipamento;
	}

	public long getQtdEventos() {
		return qtdEventos;
	}

	public void setQtdEventos(long qtdEventos) {
		this.qtdEventos = qtdEventos;
	}

	public String getNomeAlarme() {
		return nomeAlarme;
	}

	public void setNomeAlarme(String nomeAlarme) {
		this.nomeAlarme = nomeAlarme;
	}

	public String getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(String nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}
	
}
