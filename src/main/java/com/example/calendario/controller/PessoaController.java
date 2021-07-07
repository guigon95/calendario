package com.example.calendario.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.calendario.pessoa.Pessoa;
import com.example.calendario.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllPessoas() {
		List<Pessoa> pessoas = pessoaService.findAll();
		if (pessoas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable(value = "id") Long id) {
		Pessoa pessoa = pessoaService.findById(id);

		return ResponseEntity.ok(pessoa);

	}

	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {

		pessoa = pessoaService.save(pessoa);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getIdPessoa())
				.toUri();

		return ResponseEntity.created(uri).body(pessoa);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable(value = "id") Long id, @RequestBody Pessoa pessoa) {

		return ResponseEntity.ok().body(pessoaService.update(id, pessoa));

	}

}
