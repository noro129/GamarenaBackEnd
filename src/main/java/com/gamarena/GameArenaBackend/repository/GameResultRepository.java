package com.gamarena.GameArenaBackend.repository;

import com.gamarena.GameArenaBackend.entity.Game;
import com.gamarena.GameArenaBackend.entity.GameResult;
import com.gamarena.GameArenaBackend.entity.dto.GameStatsBoardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameResultRepository extends JpaRepository<GameResult, Long> {

    @Query("select new com.gamarena.GameArenaBackend.entity.dto.GameStatsBoardDTO(gr.user.username, gr.minutes, gr.seconds) " +
            "from GameResult gr " +
            "where gr.gameResult = com.gamarena.GameArenaBackend.entity.enums.GameResultEnum.WON AND gr.game=:game")
    List<GameStatsBoardDTO> getGameStats(@Param("game") Game game);
}
