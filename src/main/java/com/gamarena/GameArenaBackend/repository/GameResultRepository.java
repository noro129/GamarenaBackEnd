package com.gamarena.GameArenaBackend.repository;

import com.gamarena.GameArenaBackend.entity.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameResultRepository extends JpaRepository<GameResult, Long> {
}
