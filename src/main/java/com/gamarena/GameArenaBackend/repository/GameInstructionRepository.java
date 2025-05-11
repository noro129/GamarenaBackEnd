package com.gamarena.GameArenaBackend.repository;

import com.gamarena.GameArenaBackend.entity.Game;
import com.gamarena.GameArenaBackend.entity.GameInstruction;
import com.gamarena.GameArenaBackend.entity.dto.GameInstructionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameInstructionRepository extends JpaRepository<GameInstruction, Long> {


    @Query(" SELECT new com.gamarena.GameArenaBackend.entity.dto.GameInstructionDTO(gi.instructionNumber, gi.instruction)" +
            " FROM GameInstruction gi " +
            " WHERE gi.game=:game" +
            " ORDER BY gi.instructionNumber")
    List<GameInstructionDTO> getInstructionsList(@Param("game") Game game);
}
