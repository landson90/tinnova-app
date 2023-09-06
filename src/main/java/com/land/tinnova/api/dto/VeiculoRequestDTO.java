package com.land.tinnova.api.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoRequestDTO {

    @NotNull
    @NotEmpty(message = "O Campo titulo é obrigatório .")
    private String marca;
    private Integer ano;
    private String descicao;
    private Boolean vendido;
}
