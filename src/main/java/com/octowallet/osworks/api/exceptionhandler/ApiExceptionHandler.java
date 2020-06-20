package com.octowallet.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.octowallet.osworks.api.exceptionhandler.customexceptions.DomainException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        var fields = new ArrayList<LocalFieldError>();

        ex.getBindingResult().getAllErrors().stream().forEach(err -> {
            String nome = ((FieldError) err).getField();
            String mensagem = messageSource.getMessage(err, LocaleContextHolder.getLocale());

            fields.add(new LocalFieldError(nome, mensagem));
        });

        var error = new StandardError();
        error.setStatus(status.value());
        error.setTitulo("Um ou mais campos são inválidos. Tente novamente.");
        error.setDataHora(LocalDateTime.now());
        error.setFields(fields);

        return super.handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request) {

        var status = HttpStatus.BAD_REQUEST;

        var error = new StandardError();
        error.setStatus(status.value());
        error.setTitulo(ex.getMessage());
        error.setDataHora(LocalDateTime.now());

        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

}