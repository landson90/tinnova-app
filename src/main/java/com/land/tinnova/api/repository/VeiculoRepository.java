package com.land.tinnova.api.repository;

import com.land.tinnova.api.dto.VeiculoConsultaPorAnoDTO;
import com.land.tinnova.api.dto.VeiculoConsultaPorMarcaDTO;
import com.land.tinnova.api.model.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {

    @Query("select new com.land.tinnova.api.dto.VeiculoConsultaPorAnoDTO(v.marca, v.ano, COUNT(v.ano)) " +
            "from VeiculoEntity v GROUP BY v.ano")
    List<VeiculoConsultaPorAnoDTO> getListarPorAno();

    @Query("select new com.land.tinnova.api.dto.VeiculoConsultaPorMarcaDTO(v.marca, COUNT(v.marca)) " +
            "from VeiculoEntity v GROUP BY v.marca")
    List<VeiculoConsultaPorMarcaDTO> getListarPorMarca();
}
