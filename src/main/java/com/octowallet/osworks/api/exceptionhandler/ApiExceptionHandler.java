package com.octowallet.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        var fields = new ArrayList<LocalFieldError>();

        ex.getBindingResult().getAllErrors().stream().forEach(err -> {
            String nome = ((FieldError) err).getField();
            String mensagem = err.getDefaultMessage();

            fields.add(new LocalFieldError(nome, mensagem));
        });

        var error = new Error();
        error.setStatus(status.value());
        error.setTitulo("Um ou mais campos são inválidos. Tente novamente.");
        error.setDataHora(LocalDateTime.now());
        error.setFields(fields);

        return super.handleExceptionInternal(ex, error, headers, status, request);
    }
}