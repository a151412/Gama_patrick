package br.com.isidrocorp.eventdash.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.AlarmeDAO;
import br.com.isidrocorp.eventdash.model.Alarme;


@RestController
@CrossOrigin("*")
public class AlarmeController {
	
	@Autowired
	private AlarmeDAO dao;

	@GetMapping("/alarmestodos")
	public ArrayList<Alarme> alarmesTodos() {
		return (ArrayList<Alarme>)dao.findAll();
	}
	
}
