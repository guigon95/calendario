package com.example.calendario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.calendario.pessoa.Agenda;
import com.example.calendario.pessoa.Pessoa;
import com.example.calendario.repository.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	AgendaRepository agendaRepository;
	
	public List<Agenda> findAll() {
		return agendaRepository.findAll();
	}

	public Optional<Agenda> findById(Long idAgenda){
		
		return agendaRepository.findById(idAgenda);
		
	}
	
	public Agenda save(Agenda agenda) {
		
		float dias = ((agenda.getDataFim().getTime() - agenda.getDataInicio().getTime()) /1000/60/60/24);
		
		agenda.setDias(dias);
		
		return agendaRepository.save(agenda);
	}
	
	public void delete(Agenda agenda) {
		agendaRepository.delete(agenda);
	}
	
}
