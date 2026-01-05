package br.thullyoo.desafio_3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "TB_BENEFICIARIOS")
@Entity
@Data
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    private LocalDate dataInclusao;

    private LocalDate dataAtualizacao;
}
