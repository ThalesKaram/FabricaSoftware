package com.fabricasoftware.app_demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(callSuper = false)
@Entity
@Table(name = "administrador")
public class Administrador extends EntidadeGenerica<Long> {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    private String email;
    private String cargo;

    public Administrador() {
        super(null);
    }

    public Administrador(Long id, String email, String cargo, Pessoa pessoa) {
        super(id);
        this.email = email;
        this.cargo = cargo;
        this.pessoa = pessoa;
    }
}
