package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DocumentoRequest(
        String tipoDocumento,
        String descricao
) {
}
