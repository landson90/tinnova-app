package com.land.tinnova.api.repository;

import com.land.tinnova.api.model.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {
}
