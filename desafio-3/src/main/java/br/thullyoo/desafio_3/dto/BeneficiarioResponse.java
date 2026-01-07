package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BeneficiarioResponse(
        UUID id,
        String nome,
        String telefone,
        LocalDate dataNascimento,
        LocalDateTime dataInclusao,
        LocalDateTime dataAtualizacao,
        List<DocumentoResponse> documentos
) {
}
