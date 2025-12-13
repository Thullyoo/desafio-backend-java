package br.thullyoo.desafio_backend_java.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TB_CLIENTES")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String nome;

    private String email;

    @ManyToOne
    private Empresa empresa;
}
