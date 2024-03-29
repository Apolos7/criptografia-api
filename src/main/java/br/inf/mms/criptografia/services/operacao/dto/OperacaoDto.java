package br.inf.mms.criptografia.services.operacao.dto;

public record OperacaoDto(
        Long id,
        String documentoUsuario,
        String tokenCartaoCredito,
        Double valorOperacao
) {
}
