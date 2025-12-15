package br.thullyoo.desafio_2.dto;

import java.util.UUID;

public record ContatoResponse(
        UUID id,
        String type,
        String value
) {}