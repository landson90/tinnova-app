package com.land.tinnova.api.controller;

import com.land.tinnova.api.dto.VeiculoRequestDTO;
import com.land.tinnova.api.dto.VeiculoResponseDTO;
import com.land.tinnova.api.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {


    private VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> salvar(@RequestBody VeiculoRequestDTO dto) {
        var response = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
