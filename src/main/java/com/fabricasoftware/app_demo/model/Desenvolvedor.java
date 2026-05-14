package com.fabricasoftware.app_demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "desenvolvedor")
public class Desenvolvedor extends EntidadeGenerica<Long> {

    private String especialidades;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    private String email;

    @ToString.Exclude
    @OneToMany(mappedBy = "responsavel", fetch = FetchType.LAZY)
    private List<Ticket> ticketsResponsaveis = new ArrayList<>();

    public Desenvolvedor(){
        super(null);
    }
    public Desenvolvedor(Long id, String especialidades, String email, Pessoa pessoa) {
        super(id);
        this.especialidades = especialidades;
        this.email = email;
        this.pessoa = pessoa;
    }
}
