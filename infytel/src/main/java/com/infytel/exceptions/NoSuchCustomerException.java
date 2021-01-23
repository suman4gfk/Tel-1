package com.infytel.exceptions;

public class NoSuchCustomerException extends Exception {
    public NoSuchCustomerException() {
        super();
    }

    public NoSuchCustomerException(String message) {
        super(message);
    }
}
