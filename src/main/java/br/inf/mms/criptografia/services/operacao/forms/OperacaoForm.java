package br.inf.mms.criptografia.services.operacao.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OperacaoForm(
        @NotBlank(message = "Campo de documento do usuário é obrigatório")
        String documentoUsuario,
        @NotBlank(message = "Campo de token do cartão de crédito é obrigatório")
        String tokenCartaoCredito,
        @NotNull(message = "É necessário informar o valor da operação")
        Double valorOperacao
) {
}
