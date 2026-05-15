package com.fabricasoftware.app_demo.controller;

import com.fabricasoftware.app_demo.dto.TicketRequest;
import com.fabricasoftware.app_demo.dto.TicketResponse;
import com.fabricasoftware.app_demo.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public List<TicketResponse> listar() {
        return service.listarTodos().stream()
                .map(TicketResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TicketResponse buscarPorId(@PathVariable Long id) {
        return new TicketResponse(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TicketResponse> cadastrar(@RequestBody TicketRequest request) {
        var ticket = service.cadastrar(request.getTitulo(), request.getDescricao(),
                request.getPrioridade(), request.getCriadorId(), request.getResponsavelId());
        return ResponseEntity.status(HttpStatus.CREATED).body(new TicketResponse(ticket));
    }

    @PutMapping("/{id}")
    public TicketResponse atualizar(@PathVariable Long id, @RequestBody TicketRequest request) {
        var ticket = service.atualizar(id, request.getTitulo(), request.getDescricao(),
                request.getPrioridade(), request.getEstado(), request.getCriadorId(), request.getResponsavelId());
        return new TicketResponse(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}