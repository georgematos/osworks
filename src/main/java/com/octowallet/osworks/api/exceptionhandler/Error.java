package com.octowallet.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Error {

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