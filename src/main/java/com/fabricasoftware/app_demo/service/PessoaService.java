package com.fabricasoftware.app_demo.service;

import com.fabricasoftware.app_demo.model.Pessoa;
import com.fabricasoftware.app_demo.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> listarTodos() {
        return repository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id: " + id));
    }

    public Pessoa cadastrar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa atualizar(Long id, Pessoa dados) {
        Pessoa existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setIdade(dados.getIdade());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        Pessoa pessoa = buscarPorId(id);
        repository.delete(pessoa);
    }
}
