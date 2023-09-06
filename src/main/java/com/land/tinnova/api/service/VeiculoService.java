package com.land.tinnova.api.service;

import com.land.tinnova.api.dto.VeiculoRequestDTO;
import com.land.tinnova.api.dto.VeiculoResponseDTO;
import com.land.tinnova.api.mapper.VeiculoMapper;
import com.land.tinnova.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;
    private VeiculoMapper veiculoMapper;


    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, VeiculoMapper veiculoMapper) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoMapper = veiculoMapper;
    }

    public VeiculoResponseDTO salvar(
            VeiculoRequestDTO dto
    ) {
        var entity = veiculoMapper.toVeiculoEntity(dto);
        var response = veiculoRepository.save(entity);
        return veiculoMapper.toVeiculoResponseDTO(response);
    }
}
