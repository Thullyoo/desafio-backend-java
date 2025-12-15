package br.thullyoo.desafio_2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TB_CONTATOS")
@Data
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String type;

    private String value;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
