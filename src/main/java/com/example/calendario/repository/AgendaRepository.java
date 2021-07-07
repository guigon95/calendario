package com.example.calendario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.calendario.pessoa.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
