package com.gamarena.GameArenaBackend.controller.request;

public class GameResultRequest {
    private String gameName;
    private boolean gameWon;
    private int minutes;
    private int seconds;

    public String getGameName() {
        return gameName;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
