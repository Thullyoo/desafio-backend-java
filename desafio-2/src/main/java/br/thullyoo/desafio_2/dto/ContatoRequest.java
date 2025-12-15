package br.thullyoo.desafio_2.dto;

import java.util.UUID;

public record ContatoRequest(
        String type,
        String value,
        UUID clienteId
) {}

