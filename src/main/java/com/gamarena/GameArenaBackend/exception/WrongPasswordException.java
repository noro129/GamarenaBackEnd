package com.gamarena.GameArenaBackend.exception;

public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException(String message) {
        super(message);
    }
}
