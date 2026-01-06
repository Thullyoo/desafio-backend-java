package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;

public record DocumentoRequest(
        String tipoDocumento,
        String descricao,
        LocalDate dataInclusao,
        LocalDate dataAtualizacao
) {
}
