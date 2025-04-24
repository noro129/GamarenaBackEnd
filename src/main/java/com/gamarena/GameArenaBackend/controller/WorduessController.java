package com.gamarena.GameArenaBackend.controller;


import com.gamarena.GameArenaBackend.service.WorduessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/worduess")
@CrossOrigin("http://localhost:4200")
public class WorduessController {

    private final WorduessService worduessService;

    public WorduessController(WorduessService worduessService) {
        this.worduessService = worduessService;
    }

    @GetMapping("/generate")
    public ResponseEntity<String> generate() {
        try {
            return ResponseEntity.ok(worduessService.generate());
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
