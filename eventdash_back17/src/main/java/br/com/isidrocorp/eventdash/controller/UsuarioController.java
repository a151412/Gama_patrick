package br.com.isidrocorp.eventdash.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.UsuarioDAO;
import br.com.isidrocorp.eventdash.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperarTodos(){
		// aqui eu quero uma lógica para recuperar tudo do banco
		// fazendo um "select" 
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> realizarLogin(@RequestBody Usuario dados) {
		Usuario res = dao.findByEmailOrRacf(dados.getEmail(), dados.getRacf());
		if (res != null) {  // encontrei o usuario no banco.
			if (res.getSenha().equals(dados.getSenha())) {
				return ResponseEntity.ok(res);
			}
			else {
				return ResponseEntity.status(403).build(); // usuario foi encontrado mas a senha nao bate
			}
		}
		else{
			return ResponseEntity.notFound().build();  // porque o usuario nao foi encontrado
		}
	}
}
