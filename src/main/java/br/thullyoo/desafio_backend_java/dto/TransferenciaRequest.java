package br.thullyoo.desafio_backend_java.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record TransferenciaRequest(
        @CPF(message = "CPF inválido. Certifique-se de que o número está correto.")
        @NotBlank(message = "O CPF é obrigatório.")
        String cpf,

        @NotNull(message = "A valor é obrigatório.")
        @DecimalMin(value = "0.00", inclusive = false, message = "O valor deve ser maior que zero.")
        BigDecimal valor
) {
}
