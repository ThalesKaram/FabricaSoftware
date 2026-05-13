package com.fabricasoftware.app_demo.dto;

import com.fabricasoftware.app_demo.model.Ticket;

public class TicketResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private Long prioridade;
    private String estado;
    private PessoaResponse criador;
    private DesenvolvedorResponse responsavel;

    public TicketResponse(Ticket t) {
        this.id = t.getId();
        this.titulo = t.getTitulo();
        this.descricao = t.getDescricao();
        this.prioridade = t.getPrioridade();
        this.estado = t.getEstado() != null ? t.getEstado().name() : null;
        if (t.getCriador() != null) {
            this.criador = new PessoaResponse(t.getCriador());
        }
        if (t.getResponsavel() != null) {
            this.responsavel = new DesenvolvedorResponse(t.getResponsavel());
        }
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Long getPrioridade() { return prioridade; }
    public String getEstado() { return estado; }
    public PessoaResponse getCriador() { return criador; }
    public DesenvolvedorResponse getResponsavel() { return responsavel; }
}
