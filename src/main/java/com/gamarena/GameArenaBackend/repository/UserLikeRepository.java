package com.gamarena.GameArenaBackend.repository;

import java.util.List;
import java.util.Optional;

import com.gamarena.GameArenaBackend.entity.Game;
import com.gamarena.GameArenaBackend.entity.User;
import com.gamarena.GameArenaBackend.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {

    List<UserLike> findByUser(User user);


    Optional<UserLike> findByUserAndGame(User user, Game game);
}
