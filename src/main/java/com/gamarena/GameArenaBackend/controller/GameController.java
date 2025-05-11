package com.gamarena.GameArenaBackend.controller;

import com.gamarena.GameArenaBackend.controller.request.GameResultRequest;
import com.gamarena.GameArenaBackend.entity.dto.GameDTO;
import com.gamarena.GameArenaBackend.entity.dto.GameInstructionDTO;
import com.gamarena.GameArenaBackend.entity.dto.GameStatsBoardDTO;
import com.gamarena.GameArenaBackend.entity.dto.UserGameStatsDTO;
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
        System.out.println(gameName);
        return ResponseEntity.ok(gameService.startGame(gameName));
    }

    @PostMapping("/like")
    public ResponseEntity<Boolean> likeGame(@RequestParam String gameName) {
        return ResponseEntity.ok(gameService.likeGame(gameName));
    }

    @PostMapping("/dislike")
    public ResponseEntity<Boolean> dislikeGame(@RequestParam String gameName) {
        return ResponseEntity.ok(gameService.dislikeGame(gameName));
    }

    @PostMapping("/set-result")
    public  ResponseEntity<Boolean> setGameResult(@RequestBody GameResultRequest gameResult) {
        System.out.println(gameResult.getGameName()+" "+gameResult.isGameWon());
        return ResponseEntity.ok(gameService.setGameResult(gameResult));
    }

    @GetMapping("/stats")
    public ResponseEntity<List<GameStatsBoardDTO>> getGameStatsByHints(@RequestParam String gameName, @RequestParam int hints){
        return ResponseEntity.ok(gameService.getGameStatsByHints(gameName, hints));
    }

    @GetMapping("/stats/user")
    public ResponseEntity<List<UserGameStatsDTO>> getUserGameStats(@RequestParam String gameName){
        return ResponseEntity.ok(gameService.getUserGameStats(gameName));
    }

    @GetMapping("/instructions")
    public ResponseEntity<List<GameInstructionDTO>> getGameInstructions(@RequestParam String gameName){
        return ResponseEntity.ok(gameService.getGameInstructions(gameName));
    }
}
