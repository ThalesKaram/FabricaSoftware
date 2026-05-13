package com.fabricasoftware.app_demo.service;

import com.fabricasoftware.app_demo.model.Administrador;
import com.fabricasoftware.app_demo.model.Pessoa;
import com.fabricasoftware.app_demo.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    private final AdministradorRepository repository;

    public AdministradorService(AdministradorRepository repository) {
        this.repository = repository;
    }

    public List<Administrador> listarTodos() {
        return repository.findAll();
    }

    public Administrador buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado com id: " + id));
    }

    public Administrador cadastrar(String nome, Long idade, String email, String cargo) {
        Pessoa pessoa = new Pessoa(null, nome, idade);
        Administrador admin = new Administrador(null, email, cargo, pessoa);
        return repository.save(admin);
    }

    public Administrador atualizar(Long id, String nome, Long idade, String email, String cargo) {
        Administrador existente = buscarPorId(id);
        existente.setEmail(email);
        existente.setCargo(cargo);
        existente.getPessoa().setNome(nome);
        existente.getPessoa().setIdade(idade);
        return repository.save(existente);
    }

    public void excluir(Long id) {
        Administrador admin = buscarPorId(id);
        repository.delete(admin);
    }
}
