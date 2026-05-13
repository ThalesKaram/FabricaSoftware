package com.fabricasoftware.app_demo.controller;

import com.fabricasoftware.app_demo.dto.PessoaRequest;
import com.fabricasoftware.app_demo.dto.PessoaResponse;
import com.fabricasoftware.app_demo.model.Pessoa;
import com.fabricasoftware.app_demo.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<PessoaResponse> listar() {
        return service.listarTodos().stream()
                .map(PessoaResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PessoaResponse buscarPorId(@PathVariable Long id) {
        return new PessoaResponse(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> cadastrar(@RequestBody PessoaRequest request) {
        Pessoa pessoa = new Pessoa(null, request.getNome(), request.getIdade());
        Pessoa salva = service.cadastrar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PessoaResponse(salva));
    }

    @PutMapping("/{id}")
    public PessoaResponse atualizar(@PathVariable Long id, @RequestBody PessoaRequest request) {
        Pessoa dados = new Pessoa(null, request.getNome(), request.getIdade());
        return new PessoaResponse(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
