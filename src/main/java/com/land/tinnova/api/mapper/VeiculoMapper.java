package com.land.tinnova.api.mapper;

import com.land.tinnova.api.dto.VeiculoRequestDTO;
import com.land.tinnova.api.dto.VeiculoResponseDTO;
import com.land.tinnova.api.model.VeiculoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoResponseDTO toVeiculoResponseDTO(VeiculoEntity entity);

    VeiculoRequestDTO toVeiculoRequestDTO(VeiculoRequestDTO veiculoRequestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    VeiculoEntity toVeiculoEntity(VeiculoRequestDTO dto);
}
