package br.thullyoo.desafio_backend_java.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record AderirEmpresaRequest(
        @CPF(message = "CPF inválido. Certifique-se de que o número está correto.")
        @NotBlank(message = "O CPF é obrigatório.")
        String cpf,
        @CNPJ(message = "CNPJ inválido. Certifique-se de que o número está correto.")
        @NotBlank(message = "O CNPJ é obrigatório.")
        String cnpj
) {
}
