package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record BeneficiarioListResponse(
        UUID id,
        String nome,
        String telefone,
        LocalDate dataNascimento,
        LocalDateTime dataInclusao,
        LocalDateTime dataAtualizacao
) {
}
