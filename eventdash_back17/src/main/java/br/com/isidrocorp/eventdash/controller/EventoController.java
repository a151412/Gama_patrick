package br.com.isidrocorp.eventdash.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.EventoDAO;
import br.com.isidrocorp.eventdash.dto.EventoPorEquipamento;
import br.com.isidrocorp.eventdash.dto.EventoPorTipo;
import br.com.isidrocorp.eventdash.dto.EventosPorAlarmeEquipamento;
import br.com.isidrocorp.eventdash.dto.PeriodoConsulta;
import br.com.isidrocorp.eventdash.model.Evento;

@RestController
@CrossOrigin("*")
public class EventoController {

	@Autowired
	private EventoDAO dao;
	
	@GetMapping("/eventos")
	public ArrayList<Evento> retornarTodos(){
		ArrayList<Evento> lista;
		lista = (ArrayList<Evento>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/eventosporperiodo")
	public ArrayList<Evento> recuperarPorPeriodo(@RequestBody PeriodoConsulta periodo) {
		return dao.findAllByDataBetween(periodo.getInicio(), periodo.getFim());
	}
	
	@PostMapping("/eventosporperiodoresumoalarme")
	public ArrayList<EventoPorTipo> recuperarPorPeriodoResumo(@RequestBody PeriodoConsulta periodo) {
		return dao.recuperarPorPeriodosAlarme(periodo.getInicio(), periodo.getFim());
	}
	
	@PostMapping("/eventosporperiodoresumoequipamento")
	public ArrayList<EventoPorEquipamento> recuperarPorPeriodoResumoEquipamento(@RequestBody PeriodoConsulta periodo) {
		return dao.recuperarPorPeriodosEquipamento(periodo.getInicio(), periodo.getFim());
	}
	
	@PostMapping("/eventosporperiodoresumoequipamentoalarme")
	public ArrayList<EventosPorAlarmeEquipamento> recuperarPorPeriodoResumoAlarmeEquipamento(@RequestBody PeriodoConsulta periodo) {
		return dao.recuperarPorPeriodosAlarmeEquipamento(periodo.getInicio(), periodo.getFim());
	}
	
	
}
