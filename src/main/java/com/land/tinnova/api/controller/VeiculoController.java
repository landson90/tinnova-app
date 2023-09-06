package com.land.tinnova.api.controller;

import com.land.tinnova.api.dto.*;
import com.land.tinnova.api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {


    private VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> getVeiculoResponseDTO() {
        var response = service.getVeiculos();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> getVeiculoDetalhes(@PathVariable Long id) {
        var response = service.show(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> salvar(@RequestBody @Valid VeiculoRequestDTO dto) {
        var response = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editar(@RequestBody @Valid VeiculoRequestDTO dto,
                                                     @PathVariable Long id) {
        service.editar(dto, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody @Valid VeiculoUpdateRequestDTO dto,
                                       @PathVariable Long id) {
        service.update(dto, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        service.apagar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/listar-por-ano")
    public ResponseEntity<List<VeiculoConsultaPorAnoDTO>> getFiltroPorAno() {
        var response = service.getListarPorAno();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/listar-por-marca")
    public ResponseEntity<List<VeiculoConsultaPorMarcaDTO>> getFiltroPorMarca() {
        var response = service.getListarPorMarca();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
