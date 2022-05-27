package com.br.bookstore.domain.exceptions;

public class InvalidValueException extends RuntimeException{
    public InvalidValueException(String type) {
        super("Invalid " + " Exception");
    }
}
