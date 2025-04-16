package com.gamarena.GameArenaBackend.controller.response;

public class SignInUpResponse {

    private String token;

    public SignInUpResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
