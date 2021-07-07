package com.example.calendario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.calendario.pessoa.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
