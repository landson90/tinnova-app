package com.land.tinnova.adapters.in.controller;


import com.land.tinnova.adapters.in.mapper.VeiculoMapperInput;
import com.land.tinnova.adapters.in.request.VeiculoRequestDTO;
import com.land.tinnova.adapters.in.response.VeiculoResponseDTO;
import com.land.tinnova.application.ports.in.InsertVeiculoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private InsertVeiculoInputPort inputPort;
    private VeiculoMapperInput mapperInput;

    @Autowired
    public VeiculoController(InsertVeiculoInputPort inputPort, VeiculoMapperInput mapperInput) {
        this.inputPort = inputPort;
        this.mapperInput = mapperInput;
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> insert(
            @RequestBody VeiculoRequestDTO veiculoRequestDTO
            ) {
        var veiculoDomain = mapperInput.toVeiculoDomain(veiculoRequestDTO);
        var response = inputPort.insert(veiculoDomain);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapperInput.toVeiculoResponseDTO(response));
    }
}
