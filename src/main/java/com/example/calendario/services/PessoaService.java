package com.example.calendario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.calendario.pessoa.Pessoa;
import com.example.calendario.repository.PessoaRepository;
import com.example.calendario.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public Pessoa findById(Long idPessoa) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);

		return pessoa.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + idPessoa + ", Tipo:" + Pessoa.class.getName()));
	}

	public Pessoa save(Pessoa pessoa) {

		pessoa.setIdPessoa(null);
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa update(Long id, Pessoa pessoa) {

		Pessoa p = findById(id);
		p.setNomePessoa(pessoa.getNomePessoa());
		return pessoaRepository.save(pessoa);
	}

	public void delete(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
}
