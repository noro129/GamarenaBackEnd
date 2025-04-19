package com.gamarena.GameArenaBackend.controller;

import com.gamarena.GameArenaBackend.entity.dto.GameDTO;
import com.gamarena.GameArenaBackend.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/game")
@CrossOrigin("http://localhost:4200")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameDTO>> getGames() {
        return ResponseEntity.ok(gameService.getGames());
    }

    @PostMapping("/start")
    public ResponseEntity<Boolean> startGame(@RequestParam String gameName) {
        return ResponseEntity.ok(gameService.startGame(gameName));
    }

    @PostMapping("/like")
    public ResponseEntity<Boolean> likeGame(@RequestParam String gameName) {
        System.out.println("like button pressed on game "+gameName);
        return ResponseEntity.ok(gameService.likeGame(gameName));
    }

    @PostMapping("/dislike")
    public ResponseEntity<Boolean> dislikeGame(@RequestParam String gameName) {
        System.out.println("dislike button pressed on game "+gameName);
        return ResponseEntity.ok(gameService.dislikeGame(gameName));
    }
}
