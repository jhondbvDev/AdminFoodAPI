package com.udea.adminfood.api.exception;

public class DataNotFoundException extends GeneralRuntimeException {
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}