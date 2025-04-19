package com.gamarena.GameArenaBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String gameName;
    private int gameLikesNumber;
    private int gamePlayersNumber;

    public Long getId() {
        return id;
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

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setGameLikesNumber(int gameLikesNumber) {
        this.gameLikesNumber = gameLikesNumber;
    }

    public void setGamePlayersNumber(int gamePlayersNumber) {
        this.gamePlayersNumber = gamePlayersNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;
        return gameLikesNumber == game.gameLikesNumber && gamePlayersNumber == game.gamePlayersNumber && Objects.equals(gameName.toLowerCase(), game.gameName.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameName, gameLikesNumber, gamePlayersNumber);
    }
}
