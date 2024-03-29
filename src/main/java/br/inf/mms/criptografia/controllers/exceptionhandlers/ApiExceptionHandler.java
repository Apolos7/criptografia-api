package br.inf.mms.criptografia.controllers.exceptionhandlers;

import br.inf.mms.criptografia.controllers.exceptionhandlers.dto.ExceptionDto;
import br.inf.mms.criptografia.services.exceptions.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ExceptionDto> ReursoNaoEncontradoHandler(RecursoNaoEncontradoException exception) {
        logger.warn(exception.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDto(exception.getMessage()));
    }
}
