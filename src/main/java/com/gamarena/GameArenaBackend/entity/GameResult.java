package com.gamarena.GameArenaBackend.entity;

import com.gamarena.GameArenaBackend.entity.enums.GameResultEnum;
import jakarta.persistence.*;

@Entity
public class GameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Enumerated(EnumType.STRING)
    private GameResultEnum gameResult;
    private int minutes;
    private int seconds;

    public GameResult() {
    }

    public GameResult(Game game, User user, GameResultEnum gameResult, int minutes, int seconds) {
        this.game = game;
        this.user = user;
        this.gameResult = gameResult;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GameResultEnum getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResultEnum gameResult) {
        this.gameResult = gameResult;
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
}
