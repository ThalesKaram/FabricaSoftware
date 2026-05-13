package com.fabricasoftware.app_demo.dto;

import com.fabricasoftware.app_demo.model.Pessoa;

public class PessoaResponse {
    private Long id;
    private String nome;
    private Long idade;

    public PessoaResponse(Pessoa p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.idade = p.getIdade();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Long getIdade() { return idade; }
}
