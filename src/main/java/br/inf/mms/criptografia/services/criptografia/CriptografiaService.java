package br.inf.mms.criptografia.services.criptografia;

public interface CriptografiaService {
    String criptografarDados(String dados);

    String descriptografarDados(String dadosCriptografados);
}
