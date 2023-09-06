package com.land.tinnova.config;


import com.land.tinnova.application.core.usecase.InsertVeiculoUseCase;
import com.land.tinnova.application.ports.out.InsertVeiculoOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertVeiculoConfig {

    @Bean
    public InsertVeiculoUseCase insertVeiculoUseCase(
            InsertVeiculoOutputPort insertVeiculoOutputPort
    ) {
        return new InsertVeiculoUseCase(insertVeiculoOutputPort);
    }
}
