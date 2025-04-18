package com.gamarena.GameArenaBackend.entity;

import jakarta.persistence.*;

@Entity
public class UserLike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public UserLike() {
    }

    public UserLike(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Game getGame() {
        return game;
    }
}
