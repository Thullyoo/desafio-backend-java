package br.thullyoo.desafio_backend_java.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_EMPRESAS")
@Data
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String cnpj;

    private String nome;

    private BigDecimal taxa;

    private BigDecimal saldo;
}
