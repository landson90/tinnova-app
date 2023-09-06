package com.land.tinnova.api.service;

import com.land.tinnova.api.config.ObjectNotFoundException;
import com.land.tinnova.api.dto.VeiculoRequestDTO;
import com.land.tinnova.api.dto.VeiculoResponseDTO;
import com.land.tinnova.api.mapper.VeiculoMapper;
import com.land.tinnova.api.model.VeiculoEntity;
import com.land.tinnova.api.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<VeiculoResponseDTO> getVeiculos() {
        var listaDeVeiculos = veiculoRepository.findAll();
        var resposta = listaDeVeiculos.stream().map(m -> veiculoMapper.toVeiculoResponseDTO(m))
                .collect(Collectors.toList());
        return resposta;
    }

    public VeiculoResponseDTO show(Long id) {
        var veiculo = this.validProductToId(id);
        return veiculoMapper.toVeiculoResponseDTO(veiculo);
    }

    public void editar(VeiculoRequestDTO dto, Long id) {
        var veiculo = this.validProductToId(id);
        BeanUtils.copyProperties(dto, veiculo, "id");
        veiculoRepository.save(veiculo);

    }

    private VeiculoEntity validProductToId(Long id) {
        Optional<VeiculoEntity> product = veiculoRepository.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException(
                "Nao temos veiculo associado para esse código  " + id
        ));
    }


}
