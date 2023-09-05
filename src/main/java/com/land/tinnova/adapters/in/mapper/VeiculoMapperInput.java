package com.land.tinnova.adapters.in.mapper;

import com.land.tinnova.adapters.in.request.VeiculoRequestDTO;
import com.land.tinnova.adapters.in.response.VeiculoResponseDTO;
import com.land.tinnova.adapters.out.respository.entity.VeiculoEntity;

public interface VeiculoMapperInput {

    VeiculoEntity toVeiculoEntity(VeiculoRequestDTO veiculoRequestDTO);

    VeiculoResponseDTO toVeiculoResponseDTO(VeiculoEntity veiculoEntity);
}
