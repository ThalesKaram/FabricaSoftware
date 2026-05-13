package com.fabricasoftware.app_demo.repository;

import com.fabricasoftware.app_demo.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
}
