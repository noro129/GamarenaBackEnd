package com.gamarena.GameArenaBackend.entity.dto;

public class GameDTO {

    private String gameName;
    private int gameLikesNumber;
    private int gamePlayersNumber;
    private boolean isGameLiked;

    public GameDTO(String gameName, int gameLikesNumber, int gamePlayersNumber, boolean isGameLiked) {
        this.gameName = gameName;
        this.gameLikesNumber = gameLikesNumber;
        this.gamePlayersNumber = gamePlayersNumber;
        this.isGameLiked = isGameLiked;
    }

    public String getGameName() {
        return gameName;
    }

    public int getGameLikesNumber() {
        return gameLikesNumber;
    }

    public int getGamePlayersNumber() {
        return gamePlayersNumber;
    }

    public boolean isIsGameLiked() {
        return isGameLiked;
    }
}
