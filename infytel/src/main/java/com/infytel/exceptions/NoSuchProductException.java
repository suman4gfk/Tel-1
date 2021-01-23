package com.infytel.exceptions;

public class NoSuchProductException extends Exception {
    public NoSuchProductException() {
        super();
    }

    public NoSuchProductException(String message) {
        super(message);
    }
}
