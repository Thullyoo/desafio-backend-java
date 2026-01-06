package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;
import java.util.UUID;

public record DocumentoResponse(
        UUID id,
        String tipoDocumento,
        String descricao,
        LocalDate dataInclusao,
        LocalDate dataAtualizacao
) {
}
