package com.gamarena.GameArenaBackend.entity.dto;

public class GameStatsBoardDTO {
    private String username;
    private int minutes;
    private int seconds;

    public GameStatsBoardDTO() {
    }

    public GameStatsBoardDTO(String username, int minutes, int seconds) {
        this.username = username;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getUsername() {
        return username;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
