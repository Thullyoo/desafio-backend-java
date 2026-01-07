package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BeneficiarioRequest(
        String nome,
        String telefone,
        LocalDate dataNascimento,
        LocalDateTime dataInclusao,
        LocalDateTime dataAtualizacao,
        List<DocumentoRequest> documentos
) {
}
