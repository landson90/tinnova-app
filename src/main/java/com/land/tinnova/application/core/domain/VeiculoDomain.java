package com.land.tinnova.application.core.domain;

public class VeiculoDomain {

    private Long id;
    private String marca;
    private Integer ano;
    private String descicao;
    private Boolean vendido;


    public VeiculoDomain() {
    }

    public VeiculoDomain(Long id, String marca, Integer ano, String descicao, Boolean vendido) {
        this.id = id;
        this.marca = marca;
        this.ano = ano;
        this.descicao = descicao;
        this.vendido = vendido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }
}
