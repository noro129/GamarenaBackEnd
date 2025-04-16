package com.gamarena.GameArenaBackend.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class SignUpRequest {

    private String email;
    private String username;
    private String password;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
