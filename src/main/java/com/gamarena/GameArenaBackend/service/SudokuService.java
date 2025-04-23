package com.gamarena.GameArenaBackend.service;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SudokuService {
    private String[][] board;
    private Random random;
    private static final int SIZE = 9;
    private static final int BLOCK_SIZE = 3;
    private static final String EMPTY = "";

    public SudokuService() {
        board = new String[SIZE][SIZE];
        random = new Random();
    }

    public List<List<String>> generate() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }

        for (int box = 0; box < SIZE; box += BLOCK_SIZE) {
            fillBox(box, box);
        }

        solveBoard();

        createPuzzle();

        return convertToBlockBasedList();
    }


    private void fillBox(int row, int col) {
        String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        shuffleArray(nums);

        int index = 0;
        for (int i = 0; i < BLOCK_SIZE; i++) {
            for (int j = 0; j < BLOCK_SIZE; j++) {
                board[row + i][col + j] = nums[index++];
            }
        }
    }


    private void shuffleArray(String[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }


    private boolean solveBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (!board[row][col].equals(EMPTY)) {
                    continue;
                }

                for (int num = 1; num <= SIZE; num++) {
                    String numStr = String.valueOf(num);
                    if (isValid(row, col, numStr)) {
                        board[row][col] = numStr;

                        if (solveBoard()) {
                            return true;
                        }

                        board[row][col] = EMPTY;
                    }
                }

                return false;
            }
        }

        return true;
    }


    private boolean isValid(int row, int col, String num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i].equals(num)) {
                return false;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (board[i][col].equals(num)) {
                return false;
            }
        }

        int boxRow = row - row % BLOCK_SIZE;
        int boxCol = col - col % BLOCK_SIZE;
        for (int i = 0; i < BLOCK_SIZE; i++) {
            for (int j = 0; j < BLOCK_SIZE; j++) {
                if (board[boxRow + i][boxCol + j].equals(num)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void createPuzzle() {
        int cellsToRemove = 50;

        while (cellsToRemove > 0) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);

            if (!board[row][col].equals(EMPTY)) {
                board[row][col] = EMPTY;
                cellsToRemove--;
            }
        }
    }

    private List<List<String>> convertToBlockBasedList() {
        List<List<String>> result = new ArrayList<>();

        for (int blockRow = 0; blockRow < BLOCK_SIZE; blockRow++) {
            for (int blockCol = 0; blockCol < BLOCK_SIZE; blockCol++) {
                List<String> block = new ArrayList<>();

                for (int cellRow = 0; cellRow < BLOCK_SIZE; cellRow++) {
                    for (int cellCol = 0; cellCol < BLOCK_SIZE; cellCol++) {
                        int row = blockRow * BLOCK_SIZE + cellRow;
                        int col = blockCol * BLOCK_SIZE + cellCol;
                        block.add(board[row][col]);
                    }
                }

                result.add(block);
            }
        }

        return result;
    }

}
