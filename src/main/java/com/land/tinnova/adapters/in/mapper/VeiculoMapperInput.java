package com.land.tinnova.adapters.in.mapper;

import com.land.tinnova.adapters.in.request.VeiculoRequestDTO;
import com.land.tinnova.adapters.in.response.VeiculoResponseDTO;
import com.land.tinnova.adapters.out.respository.entity.VeiculoEntity;
import com.land.tinnova.application.core.domain.VeiculoDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface VeiculoMapperInput {

    VeiculoEntity toVeiculoEntity(VeiculoRequestDTO veiculoRequestDTO);

    VeiculoResponseDTO toVeiculoResponseDTO(VeiculoDomain veiculoDomain);


    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    VeiculoDomain toVeiculoDomain(VeiculoRequestDTO veiculoRequestDTO);
}
