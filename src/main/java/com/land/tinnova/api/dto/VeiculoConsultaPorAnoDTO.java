package com.land.tinnova.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoConsultaPorAnoDTO {

    private String marca;
    private Integer ano;
    private Long total;

}
