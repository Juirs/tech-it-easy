package com.tech_it_easy.controller.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Bad request.");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
