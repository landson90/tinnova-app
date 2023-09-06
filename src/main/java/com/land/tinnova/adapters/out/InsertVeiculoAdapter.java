package com.land.tinnova.adapters.out;

import com.land.tinnova.adapters.out.respository.VeiculoRepository;
import com.land.tinnova.adapters.out.respository.entity.VeiculoEntity;
import com.land.tinnova.adapters.out.respository.mapper.VeiculoMapperAdapters;
import com.land.tinnova.application.ports.out.InsertVeiculoOutputPort;
import com.land.tinnova.application.core.domain.VeiculoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertVeiculoAdapter implements InsertVeiculoOutputPort {

    private VeiculoRepository repository;
    private VeiculoMapperAdapters mapperAdapters;

    @Autowired
    public InsertVeiculoAdapter(VeiculoRepository repository, VeiculoMapperAdapters mapperAdapters) {
        this.repository = repository;
        this.mapperAdapters = mapperAdapters;
    }

    @Override
    public VeiculoDomain insert(VeiculoDomain veiculoDomain) {
        var veiculoEntity = getVeiculoEntity(veiculoDomain);
        var veiculoSalvo = repository.save(veiculoEntity);
        return getVeiculoDomain(veiculoSalvo);
    }

    private VeiculoEntity getVeiculoEntity(VeiculoDomain domain) {
        return VeiculoEntity.builder()
                .descicao(domain.getDescicao())
                .ano(domain.getAno())
                .vendido(domain.getVendido())
                .marca(domain.getMarca())
                .build();
    }

    private VeiculoDomain getVeiculoDomain(VeiculoEntity entity) {
       return new VeiculoDomain(
               entity.getId(),
               entity.getMarca(),
               entity.getAno(),
               entity.getDescicao(),
               entity.getVendido(),
               entity.getCreateAt(),
               entity.getUpdateAt()
       );
    }

}
