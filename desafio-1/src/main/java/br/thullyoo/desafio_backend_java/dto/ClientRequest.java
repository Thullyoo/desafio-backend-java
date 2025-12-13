package br.thullyoo.desafio_backend_java.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record ClientRequest(
        @CPF(message = "CPF inválido. Certifique-se de que o número está correto.")
        @NotBlank(message = "O CPF é obrigatório.")
        String cpf,

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @Email(message = "E-mail inválido. Certifique-se de que o e-mail está correto.")
        @NotBlank(message = "O e-mail é obrigatório.")
        String email,

        @CNPJ(message = "CNPJ inválido.")
        String empresa_cpnj
) {
}
