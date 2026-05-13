package com.fabricasoftware.app_demo.controller;

import com.fabricasoftware.app_demo.dto.DesenvolvedorRequest;
import com.fabricasoftware.app_demo.dto.DesenvolvedorResponse;
import com.fabricasoftware.app_demo.service.DesenvolvedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/desenvolvedores")
public class DesenvolvedorController {

    private final DesenvolvedorService service;

    public DesenvolvedorController(DesenvolvedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<DesenvolvedorResponse> listar() {
        return service.listarTodos().stream()
                .map(DesenvolvedorResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DesenvolvedorResponse buscarPorId(@PathVariable Long id) {
        return new DesenvolvedorResponse(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<DesenvolvedorResponse> cadastrar(@RequestBody DesenvolvedorRequest request) {
        var dev = service.cadastrar(request.getNome(), request.getIdade(),
                request.getEmail(), request.getEspecialidades());
        return ResponseEntity.status(HttpStatus.CREATED).body(new DesenvolvedorResponse(dev));
    }

    @PutMapping("/{id}")
    public DesenvolvedorResponse atualizar(@PathVariable Long id, @RequestBody DesenvolvedorRequest request) {
        var dev = service.atualizar(id, request.getNome(), request.getIdade(),
                request.getEmail(), request.getEspecialidades());
        return new DesenvolvedorResponse(dev);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
