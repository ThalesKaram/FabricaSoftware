package com.fabricasoftware.app_demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class EntidadeGenerica<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    public EntidadeGenerica(T id) {
        this.id = id;
    }
}
