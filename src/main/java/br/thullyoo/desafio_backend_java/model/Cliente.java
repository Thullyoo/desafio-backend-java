package br.thullyoo.desafio_backend_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB_CLIENTES")
@Data
public class Cliente {

    @Id
    private String cpf;

    private String nome;

    private String email;

    @ManyToOne
    private Empresa empresa;
}
