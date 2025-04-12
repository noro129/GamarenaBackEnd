package com.gamarena.GameArenaBackend.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TwinsHuntService {
    private final String[] COLORS = {
                                        "#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF", "#00FFFF",
                                        "#FF8000", "#8000FF", "#FFFFFF", "#00FF80", "#FF0080", "#808080",
                                        "#804000", "#FF8080", "#FFFF80", "#80FF80", "#8080FF", "#000000",
                                    };

    public List<List<String>> generateGame(int row, int column){
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> colorsMap = generateColorsMap((row*column) / 2);
        List<String> generateRow;

        for(int i=0; i<row; i++){
            generateRow = new ArrayList<>();
            for(int j=0; j<column; j++) {
                String pickedColor = this.getRandomSetElement(colorsMap.keySet());
                if (colorsMap.get(pickedColor)==1) colorsMap.remove(pickedColor);
                else colorsMap.put(pickedColor, 1);
                generateRow.add(pickedColor);
            }
            result.add(generateRow);
        }
        return result;
    }

    private Map<String, Integer> generateColorsMap(int numberOfColors){
        if(numberOfColors<COLORS.length){
            return new HashMap<>();
        } else {
            Map<String, Integer> result = new HashMap<>();
            for(String color : COLORS) {
                result.put(color, 2);
            }
            return result;
        }
    }

    private String getRandomSetElement(Set<String> set) {
        int item = new Random().nextInt(set.size());
        int i =0;
        for(String element : set) {
            if(i==item) return element;
            i++;
        }
        return "";
    }
}