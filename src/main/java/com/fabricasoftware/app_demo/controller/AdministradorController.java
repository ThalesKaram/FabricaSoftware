package com.fabricasoftware.app_demo.controller;

import com.fabricasoftware.app_demo.dto.AdministradorRequest;
import com.fabricasoftware.app_demo.dto.AdministradorResponse;
import com.fabricasoftware.app_demo.service.AdministradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    private final AdministradorService service;

    public AdministradorController(AdministradorService service) {
        this.service = service;
    }

    @GetMapping
    public List<AdministradorResponse> listar() {
        return service.listarTodos().stream()
                .map(AdministradorResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AdministradorResponse buscarPorId(@PathVariable Long id) {
        return new AdministradorResponse(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AdministradorResponse> cadastrar(@RequestBody AdministradorRequest request) {
        var admin = service.cadastrar(request.getNome(), request.getIdade(),
                request.getEmail(), request.getCargo());
        return ResponseEntity.status(HttpStatus.CREATED).body(new AdministradorResponse(admin));
    }

    @PutMapping("/{id}")
    public AdministradorResponse atualizar(@PathVariable Long id, @RequestBody AdministradorRequest request) {
        var admin = service.atualizar(id, request.getNome(), request.getIdade(),
                request.getEmail(), request.getCargo());
        return new AdministradorResponse(admin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
