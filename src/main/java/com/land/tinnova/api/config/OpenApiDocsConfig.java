package com.land.tinnova.api.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiDocsConfig {

    @Bean
    public OpenAPI sistemaCobrancaOpenAPI() {
        return new OpenAPI()
                .info(infoOpenAPI()
                        .contact(contactOpenAPI()))
                .externalDocs(new ExternalDocumentation()
                        .description("OpenAPI")
                        .url("https://springdoc.org"));
    }

    private Info infoOpenAPI() {
        return new Info()
                .title("Desafio Tinnova")
                .description("Desafio da empresa Tinnova")
                .version("0.0.1-SNAPSHOT");
    }

    private Contact contactOpenAPI() {
        return new Contact()
                .name("Landson Randel")
                .url("https://github.com/landson90")
                .email("randelsilva1990@gmail.com");
    }
}