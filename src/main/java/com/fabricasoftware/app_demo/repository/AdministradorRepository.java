package com.fabricasoftware.app_demo.repository;

import com.fabricasoftware.app_demo.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
