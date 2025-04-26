package com.gamarena.GameArenaBackend.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MinesweeperService {



    public List<List<Integer>> generate(Integer rows, Integer columns) {
        int[][] result = new int[rows][columns];
        Random random = new Random();
        int viruses = 40;
        while(viruses!=0) {
            int randRow = random.nextInt(rows);
            int randColumn = random.nextInt(columns);
            if (result[randRow][randColumn] == -1) continue;
            result[randRow][randColumn] = -1;
            viruses--;
        }
        for(int row=0; row<rows; row++) {
            for(int column=0; column<columns; column++) {
                if(result[row][column] == -1) continue;
                int nearViruses = 0;
                if (isVirus(result, row-1, column)) nearViruses++;
                if (isVirus(result, row-1, column-1)) nearViruses++;
                if (isVirus(result, row-1, column+1)) nearViruses++;
                if (isVirus(result, row+1, column)) nearViruses++;
                if (isVirus(result, row+1, column-1)) nearViruses++;
                if (isVirus(result, row+1, column+1)) nearViruses++;
                if (isVirus(result, row, column-1)) nearViruses++;
                if (isVirus(result, row, column+1)) nearViruses++;


                result[row][column] = nearViruses;
            }
        }
        List<List<Integer>> resultAsList = new ArrayList<>();
        for(int row=0; row<rows; row++) {
            List<Integer> aRow = new ArrayList<>();
            for(int cell : result[row]) {
                aRow.add(cell);
            }
            resultAsList.add(aRow);
        }

        return resultAsList;
    }

    private boolean isVirus(int[][] result, int row, int column) {
        return row>=0 && row<result.length && column>=0 && column<result[0].length && result[row][column] == -1;
    }
}