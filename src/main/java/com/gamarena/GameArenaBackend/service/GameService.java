package com.gamarena.GameArenaBackend.service;


import com.gamarena.GameArenaBackend.entity.Game;
import com.gamarena.GameArenaBackend.entity.PlayRecord;
import com.gamarena.GameArenaBackend.entity.User;
import com.gamarena.GameArenaBackend.entity.UserLike;
import com.gamarena.GameArenaBackend.entity.dto.GameDTO;
import com.gamarena.GameArenaBackend.repository.GameRepository;
import com.gamarena.GameArenaBackend.repository.PlayRecordRepository;
import com.gamarena.GameArenaBackend.repository.UserLikeRepository;
import com.gamarena.GameArenaBackend.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final UserLikeRepository userLikeRepository;
    private final UserRepository userRepository;
    private final PlayRecordRepository playRecordRepository;

    public GameService(GameRepository gameRepository,
                       UserLikeRepository userLikeRepository,
                       UserRepository userRepository,
                       PlayRecordRepository playRecordRepository) {
        this.gameRepository = gameRepository;
        this.userLikeRepository = userLikeRepository;
        this.userRepository = userRepository;
        this.playRecordRepository = playRecordRepository;
    }


    public List<GameDTO> getGames() {
        String username = getRequestUsername();
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

    public Boolean likeGame(String gameName) {
        String username = getRequestUsername();
        User user = userRepository.findByUsername(username).orElseThrow();
        Game game = gameRepository.findByGameName(gameName).orElseThrow();
        game.setGameLikesNumber(game.getGameLikesNumber()+1);
        gameRepository.save(game);
        userLikeRepository.save(new UserLike(user, game));
        return true;
    }

    public Boolean dislikeGame(String gameName) {
        String username = getRequestUsername();
        User user = userRepository.findByUsername(username).orElseThrow();
        Game game = gameRepository.findByGameName(gameName).orElseThrow();
        game.setGameLikesNumber(game.getGameLikesNumber()-1);
        gameRepository.save(game);
        userLikeRepository.findByUserAndGame(user, game).ifPresent(userLikeRepository::delete);
        return true;
    }

    private String getRequestUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public Boolean startGame(String gameName) {
        String username = getRequestUsername();
        User user = userRepository.findByUsername(username).orElseThrow();
        Game game = gameRepository.findByGameName(gameName).orElseThrow();
        playRecordRepository.findByUserAndGame(user, game).ifPresentOrElse(
                object -> {},
                ()->{
            game.setGamePlayersNumber(game.getGamePlayersNumber()+1);
            gameRepository.save(game);
            playRecordRepository.save(new PlayRecord(user, game));
        });
        return true;
    }
}
