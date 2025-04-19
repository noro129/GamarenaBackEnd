package com.gamarena.GameArenaBackend.repository;

import com.gamarena.GameArenaBackend.entity.Game;
import com.gamarena.GameArenaBackend.entity.PlayRecord;
import com.gamarena.GameArenaBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayRecordRepository extends JpaRepository<PlayRecord, Long> {

    Optional<PlayRecord> findByUserAndGame(User user, Game game);
}
