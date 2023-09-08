package com.land.tinnova.api.controller;

import com.land.tinnova.api.dto.*;
import com.land.tinnova.api.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Buscar Veiculos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorna todos os veiculos",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VeiculoResponseDTO.class))})})
    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> getVeiculoResponseDTO() {
        var response = service.getVeiculos();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Buscar Veiculo por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorna veiculo por id",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VeiculoResponseDTO.class))})})
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> getVeiculoDetalhes(
            @Parameter(description = "id do veiculo")
            @PathVariable Long id
    ) {
        var response = service.show(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Salvar veiculo")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Retorna veiculo criado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VeiculoResponseDTO.class))})})
    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> salvar(
            @Parameter(description = "Objeto VeiculoRequestDTO")
            @RequestBody @Valid VeiculoRequestDTO dto) {
        var response = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Salvar alteração de veiculo completa")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Retornar nenhum conteudo",
                    content = {@Content(
                            mediaType = "application/json")})})
    @PutMapping("/{id}")
    public ResponseEntity<Void> editar(
            @Parameter(description = "Objeto VeiculoRequestDTO")
            @RequestBody @Valid VeiculoRequestDTO dto,
            @Parameter(description = "id do veiculo")
            @PathVariable Long id
    ) {
        service.editar(dto, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Salvar alteração de veiculo parcial")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Retornar nenhum conteudo",
                    content = {@Content(
                            mediaType = "application/json")})})
    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizar(
            @Parameter(description = "Objeto VeiculoUpdateRequestDTO")
            @RequestBody @Valid VeiculoUpdateRequestDTO dto,
            @Parameter(description = "id do veiculo")
            @PathVariable Long id) {
        service.update(dto, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Excluir veiculo por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Retornar nenhum conteudo",
                    content = {@Content(
                            mediaType = "application/json")})})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(
            @Parameter(description = "id do veiculo")
            @PathVariable Long id
    ) {
        service.apagar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Listar veiculos por ano")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Retornar lista de veiculos por ano",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VeiculoConsultaPorAnoDTO.class))})})
    @GetMapping("/listar-por-ano")
    public ResponseEntity<List<VeiculoConsultaPorAnoDTO>> getFiltroPorAno() {
        var response = service.getListarPorAno();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Listar veiculos por marca")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Retornar lista de veiculos por marca",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VeiculoConsultaPorMarcaDTO.class))})})
    @GetMapping("/listar-por-marca")
    public ResponseEntity<List<VeiculoConsultaPorMarcaDTO>> getFiltroPorMarca() {
        var response = service.getListarPorMarca();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
