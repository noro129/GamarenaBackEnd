package com.gamarena.GameArenaBackend.controller;


import com.gamarena.GameArenaBackend.service.SudokuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sudoku")
@CrossOrigin("http://localhost:4200")
public class SudokuController {

    private final SudokuService sudokuService;

    public SudokuController(SudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }


    @GetMapping("/generate")
    public ResponseEntity<List<List<String>>> generate() {
        return ResponseEntity.ok(sudokuService.generate());
    }
}
