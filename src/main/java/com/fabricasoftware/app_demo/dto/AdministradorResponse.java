package com.fabricasoftware.app_demo.dto;

import com.fabricasoftware.app_demo.model.Administrador;

public class AdministradorResponse {

    private Long id;
    private String nome;
    private Long idade;
    private String email;
    private String cargo;

    public AdministradorResponse(Administrador a) {
        this.id = a.getId();
        this.email = a.getEmail();
        this.cargo = a.getCargo();
        if (a.getPessoa() != null) {
            this.nome = a.getPessoa().getNome();
            this.idade = a.getPessoa().getIdade();
        }
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Long getIdade() { return idade; }
    public String getEmail() { return email; }
    public String getCargo() { return cargo; }
}
