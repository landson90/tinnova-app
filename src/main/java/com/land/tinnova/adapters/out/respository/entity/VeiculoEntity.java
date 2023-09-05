package com.land.tinnova.adapters.out.respository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.OffsetDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_veiculo")
public class VeiculoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private Integer ano;
    private String descicao;
    private Boolean vendido;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private OffsetDateTime createAt;
    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private OffsetDateTime updateAt;

}
