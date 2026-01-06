package br.thullyoo.desafio_3.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record BeneficiarioResponse(UUID id, String nome, String telefone, LocalDate dataNascimento, LocalDate dataInclusao, LocalDate dataAtualizacao, List<DocumentoResponse> documentos) {
}
