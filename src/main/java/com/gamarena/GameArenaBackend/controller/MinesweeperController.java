package com.gamarena.GameArenaBackend.controller;


import com.gamarena.GameArenaBackend.service.MinesweeperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/minesweeper")
@CrossOrigin("http://localhost:4200")
public class MinesweeperController {

    private final MinesweeperService minesweeperService;

    public MinesweeperController(MinesweeperService minesweeperService) {
        this.minesweeperService = minesweeperService;
    }


    @GetMapping("/generate")
    public ResponseEntity<List<List<Integer>>> generate(@RequestParam Integer rows,
                                                        @RequestParam Integer columns) {
        return ResponseEntity.ok(minesweeperService.generate(rows, columns));
    }
}
