package com.octowallet.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL) // inclua apenas campos não nulos
public class StandardError {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;

    private List<LocalFieldError> fields;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<LocalFieldError> getFields() {
        return fields;
    }

    public void setFields(List<LocalFieldError> fields) {
        this.fields = fields;
    }

}