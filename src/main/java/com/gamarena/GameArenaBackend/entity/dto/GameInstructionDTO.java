package com.gamarena.GameArenaBackend.entity.dto;

public class GameInstructionDTO {
    private int instructionNumber;
    private String instruction;

    public GameInstructionDTO(int instructionNumber, String instruction) {
        this.instructionNumber = instructionNumber;
        this.instruction = instruction;
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
