package com.gamarena.GameArenaBackend.repository;

import com.gamarena.GameArenaBackend.entity.Game;
import com.gamarena.GameArenaBackend.entity.GameInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameInstructionRepository extends JpaRepository<GameInstruction, Long> {


    @Query(" SELECT gi.instruction" +
            " FROM GameInstruction gi " +
            " WHERE gi.game=:game" +
            " ORDER BY gi.instructionNumber")
    List<String> getInstructionsList(@Param("game") Game game);
}
