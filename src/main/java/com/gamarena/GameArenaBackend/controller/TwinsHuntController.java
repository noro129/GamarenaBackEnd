package com.gamarena.GameArenaBackend.controller;


import com.gamarena.GameArenaBackend.service.TwinsHuntService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("twins-hunt")
@CrossOrigin("http://localhost:4200")
public class TwinsHuntController {
    private final TwinsHuntService twinsHuntService;

    public TwinsHuntController(TwinsHuntService twinsHuntService) {
        this.twinsHuntService = twinsHuntService;
    }

    @GetMapping("/generate")
    public ResponseEntity<List<List<String>>> generateGame(@RequestParam Integer row,
                                                           @RequestParam Integer column){
        return ResponseEntity.ok(twinsHuntService.generateGame(row, column));
    }
}
