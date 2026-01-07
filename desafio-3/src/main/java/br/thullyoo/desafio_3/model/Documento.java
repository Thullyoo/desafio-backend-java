package br.thullyoo.desafio_3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "TB_DOCUMENTOS")
@Entity
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tipoDocumento;

    private String descricao;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
}
