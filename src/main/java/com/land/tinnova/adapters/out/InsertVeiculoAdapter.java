package com.land.tinnova.adapters.out;

import com.land.tinnova.application.ports.out.InsertVeiculoOutputPort;
import com.land.tinnova.application.core.domain.VeiculoDomain;
import org.springframework.stereotype.Component;

@Component
public class InsertVeiculoAdapter implements InsertVeiculoOutputPort {



    @Override
    public VeiculoDomain insert(VeiculoDomain veiculoDomain) {
        return null;
    }
}
