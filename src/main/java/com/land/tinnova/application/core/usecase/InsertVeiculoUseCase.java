package com.land.tinnova.application.core.usecase;

import com.land.tinnova.application.core.domain.VeiculoDomain;
import com.land.tinnova.application.ports.in.InsertVeiculoInputPort;
import com.land.tinnova.application.ports.out.InsertVeiculoOutputPort;

public class InsertVeiculoUseCase implements InsertVeiculoInputPort {

    private final InsertVeiculoOutputPort insertVeiculoOutputPort;


    public InsertVeiculoUseCase(InsertVeiculoOutputPort insertVeiculoOutputPort) {
        this.insertVeiculoOutputPort = insertVeiculoOutputPort;
    }

    @Override
    public VeiculoDomain insert(VeiculoDomain veiculoDomain) {
        var veiculo = insertVeiculoOutputPort.insert(veiculoDomain);
        return veiculo;
    }
}
