package com.gamarena.GameArenaBackend.entity.dto;

public class UserGameStatsDTO {
    private int minutes;
    private int seconds;
    private int hints;

    public UserGameStatsDTO(int minutes, int seconds, int hints) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.hints = hints;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getHints() {
        return hints;
    }

    public void setHints(int hints) {
        this.hints = hints;
    }
}
