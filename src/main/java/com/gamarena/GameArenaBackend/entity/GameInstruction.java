package com.gamarena.GameArenaBackend.entity;

import jakarta.persistence.*;

@Entity
public class GameInstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
    private int instructionNumber;
    private String instruction;

    public GameInstruction() {
    }

    public GameInstruction(Game game, int instructionNumber, String instruction) {
        this.game = game;
        this.instructionNumber = instructionNumber;
        this.instruction = instruction;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getInstructionNumber() {
        return instructionNumber;
    }

    public void setInstructionNumber(int instructionNumber) {
        this.instructionNumber = instructionNumber;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
