package com.gamarena.GameArenaBackend.service;


import com.gamarena.GameArenaBackend.entity.Game;
import com.gamarena.GameArenaBackend.entity.User;
import com.gamarena.GameArenaBackend.entity.UserLike;
import com.gamarena.GameArenaBackend.entity.dto.GameDTO;
import com.gamarena.GameArenaBackend.repository.GameRepository;
import com.gamarena.GameArenaBackend.repository.UserLikeRepository;
import com.gamarena.GameArenaBackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final UserLikeRepository userLikeRepository;
    private final UserRepository userRepository;

    public GameService(GameRepository gameRepository,
                       UserLikeRepository userLikeRepository,
                       UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userLikeRepository = userLikeRepository;
        this.userRepository = userRepository;
    }


    public List<GameDTO> getGames(String username) {
        List<Game> games = gameRepository.findAll();
        User user = userRepository.findByUsername(username).orElseThrow();
        List<UserLike> userLikes = userLikeRepository.findByUser(user);
        return getGames(games, userLikes);
    }

    private List<GameDTO> getGames(List<Game> games, List<UserLike> userLikes) {
        Set<Long> likedGamesIdsSet = getLikedGamesIds(userLikes);
        List<GameDTO> result = new ArrayList<>();
        for (Game game : games) {
            result.add(new GameDTO(
                    game.getGameName(),
                    game.getGameLikesNumber(),
                    game.getGamePlayersNumber(),
                    likedGamesIdsSet.contains(game.getId())
            ));
        }
        return result;
    }

    private Set<Long> getLikedGamesIds(List<UserLike> userLikes) {
        Set<Long> result = new HashSet<>();
        for(UserLike userLike : userLikes) {
            result.add(userLike.getGame().getId());
        }
        return result;
    }
}
