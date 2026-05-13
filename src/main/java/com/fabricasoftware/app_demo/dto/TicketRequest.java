package com.fabricasoftware.app_demo.dto;

public class TicketRequest {
    private String titulo;
    private String descricao;
    private Long prioridade;
    private Long criadorId;
    private Long responsavelId;
    private String estado;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Long getPrioridade() { return prioridade; }
    public void setPrioridade(Long prioridade) { this.prioridade = prioridade; }
    public Long getCriadorId() { return criadorId; }
    public void setCriadorId(Long criadorId) { this.criadorId = criadorId; }
    public Long getResponsavelId() { return responsavelId; }
    public void setResponsavelId(Long responsavelId) { this.responsavelId = responsavelId; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
