package com.land.tinnova.adapters.out.respository.mapper;


import com.land.tinnova.adapters.out.respository.entity.VeiculoEntity;
import com.land.tinnova.application.core.domain.VeiculoDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapperAdapters {

    VeiculoEntity toVeiculoEntity(VeiculoDomain veiculoDomain);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    VeiculoDomain toVeiculoDomain(VeiculoEntity veiculoEntity);

}
