package com.example.calendario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.calendario.pessoa.Agenda;
import com.example.calendario.pessoa.Pessoa;
import com.example.calendario.services.AgendaService;

@RestController
@RequestMapping(value = "/agendas")
public class AgendaController {

	@Autowired
	AgendaService agendaService;
	
	
	  @GetMapping
	    public ResponseEntity<List<Agenda>> getAllAgendas(){
	      List<Agenda> agendas = agendaService.findAll();
	        if(agendas.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }else {
	            return new ResponseEntity<List<Agenda>>(agendas, HttpStatus.OK);
	        }
	    }
	  
	 @GetMapping("/{id}")
	    public ResponseEntity<Agenda> getUmaAgenda(@PathVariable(value="id") Long id){
	        Optional<Agenda> agenda = agendaService.findById(id);
	        if(!agenda.isPresent()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }else {
	            return new ResponseEntity<Agenda>(agenda.get(), HttpStatus.OK);
	        }
	    }
	 
	@PostMapping
	public ResponseEntity<Agenda> save(@RequestBody Agenda agenda){
		
		return new ResponseEntity<Agenda>(agendaService.save(agenda), HttpStatus.CREATED);
		
	}
	
	 @PutMapping("/{id}")
	 public ResponseEntity<Agenda> update(@PathVariable(value="id") Long id,
	                                                      @RequestBody Agenda agenda) {
	        Optional<Agenda> p = agendaService.findById(id);
	        if(!p.isPresent()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }else {
	            agenda.setIdAgenda(p.get().getIdAgenda());
	            return new ResponseEntity<Agenda>(agendaService.save(agenda), HttpStatus.OK);
	        }
	   }
	
}
