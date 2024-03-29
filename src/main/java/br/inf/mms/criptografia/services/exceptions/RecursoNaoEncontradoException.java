package br.inf.mms.criptografia.services.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String recurso, Long id) {
        super("Recurso '" + recurso + "' não encontrado com o ID " + id);
    }
}
