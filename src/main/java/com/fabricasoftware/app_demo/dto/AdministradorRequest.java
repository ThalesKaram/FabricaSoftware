package com.fabricasoftware.app_demo.dto;

public class AdministradorRequest {

    private String nome;
    private Long idade;
    private String email;
    private String cargo;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Long getIdade() { return idade; }
    public void setIdade(Long idade) { this.idade = idade; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
