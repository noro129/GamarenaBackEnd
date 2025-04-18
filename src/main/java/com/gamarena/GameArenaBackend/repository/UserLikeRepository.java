package com.gamarena.GameArenaBackend.repository;

import java.util.List;

import com.gamarena.GameArenaBackend.entity.User;
import com.gamarena.GameArenaBackend.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {

    List<UserLike> findByUser(User user);
}
