package com.land.tinnova.api.mapper;

import com.land.tinnova.api.dto.VeiculoRequestDTO;
import com.land.tinnova.api.dto.VeiculoResponseDTO;
import com.land.tinnova.api.dto.VeiculoUpdateRequestDTO;
import com.land.tinnova.api.model.VeiculoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoResponseDTO toVeiculoResponseDTO(VeiculoEntity entity);

    VeiculoRequestDTO toVeiculoRequestDTO(VeiculoRequestDTO veiculoRequestDTO);

    VeiculoEntity toVeiculoEntity(VeiculoRequestDTO veiculoRequestDTO);



}
