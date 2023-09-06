package com.land.tinnova.adapters.out.respository.mapper;


import com.land.tinnova.adapters.out.respository.entity.VeiculoEntity;
import com.land.tinnova.application.core.domain.VeiculoDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapperAdapters {



    VeiculoEntity toVeiculoEntity(VeiculoDomain veiculoDomain);

    VeiculoDomain toVeiculoDomain(VeiculoEntity veiculoEntity);

}
