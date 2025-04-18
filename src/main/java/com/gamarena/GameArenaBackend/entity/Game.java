package com.gamarena.GameArenaBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
}
