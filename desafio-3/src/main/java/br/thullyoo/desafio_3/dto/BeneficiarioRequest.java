package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;
import java.util.List;

public record BeneficiarioRequest(
        String nome,
        String telefone,
        LocalDate dataNascimento,
        LocalDate dataInclusao,
        LocalDate dataAtualizacao,
        List<DocumentoRequest> documentos
) {
}
