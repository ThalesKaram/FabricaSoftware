package com.fabricasoftware.app_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(callSuper = false)
@Entity
@Table(name = "pessoa")
public class Pessoa extends EntidadeGenerica<Long> {

    private String nome;
    private Long idade;

    @ToString.Exclude
    @OneToMany(mappedBy = "criador", fetch = FetchType.LAZY)
    private List<Ticket> ticketsCriados = new ArrayList<>();

    public Pessoa(){
        super(null);
    }

    public Pessoa(Long id, String nome, Long idade) {
        super(id);
        this.nome = nome;
        this.idade = idade;
    }
}
