package com.land.tinnova.application.ports.out;

import com.land.tinnova.application.core.domain.VeiculoDomain;

public interface InsertVeiculoOutputPort {

    VeiculoDomain insert(VeiculoDomain veiculoDomain);
}
