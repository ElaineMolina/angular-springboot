package com.molina.helpdesk.services.exceptions;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable{

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ObjectNotFoundException(String message) {
        super(message);
    }

}
