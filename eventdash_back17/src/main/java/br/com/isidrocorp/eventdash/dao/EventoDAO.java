package br.com.isidrocorp.eventdash.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.isidrocorp.eventdash.dto.EventoPorEquipamento;
import br.com.isidrocorp.eventdash.dto.EventosPorAlarmeEquipamento;
import br.com.isidrocorp.eventdash.dto.EventoPorTipo;
import br.com.isidrocorp.eventdash.model.Evento;


public interface EventoDAO extends CrudRepository<Evento, Integer>{

	public ArrayList<Evento> findAllByDataBetween(LocalDate inicio, LocalDate fim);
	
	@Query("Select new br.com.isidrocorp.eventdash.dto.EventoPorTipo (count(e.numSeq), a.nome) " +
			"from Alarme a inner join Evento e on a.id=e.alarme.id " + 
			"where e.data>=:inicio and e.data<=:fim " +
			"group by a.id")
	public ArrayList<EventoPorTipo> recuperarPorPeriodosAlarme(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
	
	@Query("Select new br.com.isidrocorp.eventdash.dto.EventoPorEquipamento (count(e.numSeq), eq.hostname) " +
			"from Equipamento eq inner join Evento e on eq.id=e.equipamento.id " + 
			"where e.data>=:inicio and e.data<=:fim " +
			"group by eq.id")
	public ArrayList<EventoPorEquipamento> recuperarPorPeriodosEquipamento(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
	
	
	@Query("Select new br.com.isidrocorp.eventdash.dto.EventosPorAlarmeEquipamento (count(e.numSeq), a.nome, eq.hostname) " +
			"from Equipamento eq inner join Evento e on eq.id=e.equipamento.id inner join Alarme a on a.id=e.alarme.id " + 
			"where e.data>=:inicio and e.data<=:fim " +
			"group by eq.id, a.id order by eq.id")
	public ArrayList<EventosPorAlarmeEquipamento> recuperarPorPeriodosAlarmeEquipamento(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
	
}
