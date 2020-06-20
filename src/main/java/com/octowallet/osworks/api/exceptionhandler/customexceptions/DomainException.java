package com.octowallet.osworks.api.exceptionhandler.customexceptions;

public class DomainException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DomainException(String msg) {
        super(msg);
    }

    public DomainException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
}                                                      