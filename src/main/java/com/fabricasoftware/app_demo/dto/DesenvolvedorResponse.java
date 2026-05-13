package com.fabricasoftware.app_demo.dto;

import com.fabricasoftware.app_demo.model.Desenvolvedor;

public class DesenvolvedorResponse {
    private Long id;
    private String nome;
    private Long idade;
    private String email;
    private String especialidades;

    public DesenvolvedorResponse(Desenvolvedor d) {
        this.id = d.getId();
        this.email = d.getEmail();
        this.especialidades = d.getEspecialidades();
        if (d.getPessoa() != null) {
            this.nome = d.getPessoa().getNome();
            this.idade = d.getPessoa().getIdade();
        }
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Long getIdade() { return idade; }
    public String getEmail() { return email; }
    public String getEspecialidades() { return especialidades; }
}
