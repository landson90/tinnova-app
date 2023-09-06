package com.land.tinnova.api.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoRequestDTO {

    private String marca;
    private Integer ano;
    private String descicao;
    private Boolean vendido;
}
