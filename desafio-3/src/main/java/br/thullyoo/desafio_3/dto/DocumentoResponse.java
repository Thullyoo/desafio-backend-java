package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record DocumentoResponse(
        UUID id,
        String tipoDocumento,
        String descricao,
        LocalDateTime dataInclusao,
        LocalDateTime dataAtualizacao
) {
}
