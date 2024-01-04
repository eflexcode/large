package com.larrex.large.exception;

public class NotFoundExceptionHandler extends Exception {

    public static final long serialVersionUID = 1L;

    public NotFoundExceptionHandler(String message) {
        super(message);
    }
}
