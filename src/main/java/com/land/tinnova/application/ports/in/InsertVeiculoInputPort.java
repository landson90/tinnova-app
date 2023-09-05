package com.land.tinnova.application.ports.in;

import com.land.tinnova.application.core.domain.VeiculoDomain;

public interface InsertVeiculoInputPort {

    VeiculoDomain insert(VeiculoDomain veiculoDomain);
}
