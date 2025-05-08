package com.gamarena.GameArenaBackend.service;


import com.gamarena.GameArenaBackend.controller.request.GameResultRequest;
import com.gamarena.GameArenaBackend.entity.*;
import com.gamarena.GameArenaBackend.entity.dto.GameDTO;
import com.gamarena.GameArenaBackend.entity.enums.GameResultEnum;
import com.gamarena.GameArenaBackend.repository.*;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final PlayRecordRepository playRecordRepository;
    private final GameResultRepository gameResultRepository;

    public GameService(GameRepository gameRepository,
                       UserLikeRepository userLikeRepository,
                       UserRepository userRepository,
                       PlayRecordRepository playRecordRepository, GameResultRepository gameResultRepository) {
        this.gameRepository = gameRepository;
        this.userLikeRepository = userLikeRepository;
        this.userRepository = userRepository;
        this.playRecordRepository = playRecordRepository;
        this.gameResultRepository = gameResultRepository;
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

    public Boolean setGameResult(GameResultRequest gameResult) {
        String username = getRequestUsername();
        User user = userRepository.findByUsername(username).orElseThrow();
        Game game = gameRepository.findByGameName(gameResult.getGameName()).orElseThrow();
        GameResultEnum result = gameResult.isGameWon() ? GameResultEnum.WON : GameResultEnum.LOST;
        int minutes = gameResult.isGameWon() ? gameResult.getMinutes() : 0;
        int seconds = gameResult.isGameWon() ? gameResult.getSeconds() : 0;
        gameResultRepository.save(new GameResult(game, user, result, minutes, seconds));
        return true;
    }
}
