package com.gamarena.GameArenaBackend.exception;

public class EmailAlreadyUsedException extends RuntimeException{

    public EmailAlreadyUsedException(String message) {
        super(message);
    }
}
