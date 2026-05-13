package com.fabricasoftware.app_demo.repository;

import com.fabricasoftware.app_demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCriadorId(Long criadorId);
    List<Ticket> findByResponsavelId(Long responsavelId);
}
