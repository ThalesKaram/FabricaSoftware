package com.fabricasoftware.app_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(callSuper = false)
@Entity
@Table(name = "ticket")
public class Ticket extends EntidadeGenerica<Long> {

    private String titulo;
    private String descricao;
    private Long prioridade;

    @Enumerated(EnumType.STRING)
    private EstadoTicket estado;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_id")
    private Desenvolvedor responsavel;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criador_id")
    private Pessoa criador;

    public Ticket(){
        super(null);
    }

    public Ticket(Long id, String titulo, String descricao, Long prioridade, EstadoTicket estado,
            Desenvolvedor responsavel, Pessoa criador) {
        super(id);
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.estado = estado;
        this.responsavel = responsavel;
        this.criador = criador;
    }
}
