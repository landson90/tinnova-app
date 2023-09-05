package com.land.tinnova.adapters.in.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponseDTO {

    private Long id;
    private String marca;
    private Integer ano;
    private String descicao;
    private Boolean vendido;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;
}
