package Lessen3;

import java.util.*;

public class Java2HomeWork3Part1 {
    public static void main(String[] args) {
        decision();
    }
    private static void decision() {
        String[] animals = {"Dog", "Pork", "Cat", "Horse", "Leon", "Crocodile",
                "Bear", "Hippopotamus", "Leon", "Giraffe",
                "Deer", "Elephant", "Squirrel", "Leon", "Pork"};


        Map<String, Integer> map = new HashMap<>();
        for (String animal : animals) {
            if (map.containsKey(animal)) {
                map.put(animal, map.get(animal) + 1);
            } else {
                map.put(animal, 1);
            }
            System.out.println(map);
        }
    }
}


