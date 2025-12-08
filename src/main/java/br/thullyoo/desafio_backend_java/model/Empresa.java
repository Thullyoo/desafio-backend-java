package br.thullyoo.desafio_backend_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_EMPRESAS")
@Data
public class Empresa {

    @Id
    private String cnpj;

    private String nome;

    private BigDecimal taxa;

    private BigDecimal saldo;
}
