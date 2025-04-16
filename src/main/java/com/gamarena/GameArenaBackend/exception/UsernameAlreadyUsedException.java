package com.gamarena.GameArenaBackend.exception;

public class UsernameAlreadyUsedException extends RuntimeException{

    public UsernameAlreadyUsedException(String message) {
        super(message);
    }
}
