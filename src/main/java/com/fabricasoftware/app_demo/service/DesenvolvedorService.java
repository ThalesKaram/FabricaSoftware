package com.fabricasoftware.app_demo.service;

import com.fabricasoftware.app_demo.model.Desenvolvedor;
import com.fabricasoftware.app_demo.model.Pessoa;
import com.fabricasoftware.app_demo.repository.DesenvolvedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesenvolvedorService {

    private final DesenvolvedorRepository repository;

    public DesenvolvedorService(DesenvolvedorRepository repository) {
        this.repository = repository;
    }

    public List<Desenvolvedor> listarTodos() {
        return repository.findAll();
    }

    public Desenvolvedor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desenvolvedor não encontrado com id: " + id));
    }

    public Desenvolvedor cadastrar(String nome, Long idade, String email, String especialidades) {
        Pessoa pessoa = new Pessoa(null, nome, idade);
        Desenvolvedor dev = new Desenvolvedor(null, especialidades, email, pessoa);
        return repository.save(dev);
    }

    public Desenvolvedor atualizar(Long id, String nome, Long idade, String email, String especialidades) {
        Desenvolvedor existente = buscarPorId(id);
        existente.setEmail(email);
        existente.setEspecialidades(especialidades);
        existente.getPessoa().setNome(nome);
        existente.getPessoa().setIdade(idade);
        return repository.save(existente);
    }

    public void excluir(Long id) {
        Desenvolvedor dev = buscarPorId(id);
        repository.delete(dev);
    }
}
