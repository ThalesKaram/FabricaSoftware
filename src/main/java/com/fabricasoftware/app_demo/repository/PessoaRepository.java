package com.fabricasoftware.app_demo.repository;

import com.fabricasoftware.app_demo.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
