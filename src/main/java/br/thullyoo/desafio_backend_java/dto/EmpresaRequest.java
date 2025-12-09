package br.thullyoo.desafio_backend_java.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigDecimal;

public record EmpresaRequest(

        @CNPJ(message = "CNPJ inválido. Certifique-se de que o número está correto.")
        @NotBlank(message = "O CNPJ é obrigatório.")
        String cnpj,

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotNull(message = "A taxa é obrigatória.")
        @DecimalMin(value = "0.00", inclusive = false, message = "O valor deve ser maior que zero.")
        BigDecimal taxa
) {
}
