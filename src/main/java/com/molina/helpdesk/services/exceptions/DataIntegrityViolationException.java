package com.molina.helpdesk.services.exceptions;

import java.io.Serializable;

public class DataIntegrityViolationException extends RuntimeException implements Serializable{

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataIntegrityViolationException(String message) {
        super(message);
    }

}
