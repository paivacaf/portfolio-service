package com.nomadit.api.portfolio.interfaces.web.exceptions;

import com.nomadit.api.portfolio.application.exceptions.NenhumConteudoEncontradoException;
import com.nomadit.api.portfolio.application.exceptions.RegraDeNegocioNaoAtendidaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String errorMessage = fieldErrors.stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ResponseStatus( HttpStatus.NO_CONTENT )
    @ExceptionHandler( NenhumConteudoEncontradoException.class )
    public void handlerNoContentException( WebRequest request ) {
        log.debug( "[GlobalExceptionHandler.handlerNoContentException] " + request.getContextPath() );
    }

    @ExceptionHandler( RegraDeNegocioNaoAtendidaException.class )
    public ResponseEntity<String> handlerUnprocessableEntity( RegraDeNegocioNaoAtendidaException ex, WebRequest request ) {
        log.debug( "[GlobalExceptionHandler.handlerUnprocessableEntity] " + request.getContextPath() );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMensagem());
    }
    
}
