package com.gamarena.GameArenaBackend.repository;

import com.gamarena.GameArenaBackend.entity.Game;
import com.gamarena.GameArenaBackend.entity.dto.GameDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


}
