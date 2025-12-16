package br.thullyoo.desafio_2.dto;

import java.util.List;

public record ClienteResponse(
        String name,
        String email,
        List<ContatoResponse> contatos
) {
}
