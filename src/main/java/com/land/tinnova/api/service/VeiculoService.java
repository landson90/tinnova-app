package com.land.tinnova.api.service;

import com.land.tinnova.api.config.ObjectNotFoundException;
import com.land.tinnova.api.dto.*;
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
        var entity =  toVeiculoEntity(dto);
        var response = veiculoRepository.save(entity);
        return getVeiculoResponseDTO(response);
    }

    public List<VeiculoResponseDTO> getVeiculos() {
        var listaDeVeiculos = veiculoRepository.findAll();
        var resposta = listaDeVeiculos.stream().map(m -> getVeiculoResponseDTO(m))
                .collect(Collectors.toList());
        return resposta;
    }

    public VeiculoResponseDTO show(Long id) {
        var veiculo = this.validProductToId(id);
        return getVeiculoResponseDTO(veiculo);
    }

    public void editar(VeiculoRequestDTO dto, Long id) {
        var veiculo = this.validProductToId(id);
        BeanUtils.copyProperties(dto, veiculo, "id");
        veiculoRepository.save(veiculo);

    }

    public void apagar(Long id) {
        var veiculo = this.validProductToId(id);
        veiculoRepository.delete(veiculo);
    }

    public void update(VeiculoUpdateRequestDTO dto, Long id) {
        var veiculo = this.validProductToId(id);
        var veiculoParaEditar = this.getEntity(dto);
        BeanUtils.copyProperties(veiculoParaEditar, veiculo, "id", "ano", "createAt", "vendido");
        veiculoRepository.save(veiculo);

    }

    public List<VeiculoConsultaPorAnoDTO> getListarPorAno() {
        var resposta = veiculoRepository.getListarPorAno();
        return resposta;
    }

    public List<VeiculoConsultaPorMarcaDTO> getListarPorMarca() {
        var resposta = veiculoRepository.getListarPorMarca();
        return resposta;
    }

    private VeiculoEntity validProductToId(Long id) {
        Optional<VeiculoEntity> product = veiculoRepository.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException(
                "Nao temos veiculo associado para esse código  " + id
        ));
    }



    private VeiculoEntity getEntity(VeiculoUpdateRequestDTO dto) {
        return VeiculoEntity.builder()
                .descricao(dto.getDescricao())
                .marca(dto.getMarca())
                .build();
    }

    private VeiculoEntity toVeiculoEntity(VeiculoRequestDTO dto) {
        return VeiculoEntity.builder()
                .descricao(dto.getDescricao())
                .marca(dto.getMarca())
                .ano(dto.getAno())
                .vendido(dto.getVendido())
                .build();
    }

    private VeiculoResponseDTO getVeiculoResponseDTO(VeiculoEntity entity) {
        return  VeiculoResponseDTO.builder()
                .id(entity.getId())
                .marca(entity.getMarca())
                .ano(entity.getAno())
                .descricao(entity.getDescricao())
                .vendido(entity.getVendido())
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .build();
    }

}
