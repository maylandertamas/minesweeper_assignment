package com.minespweeper.codecool;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int GenerateRandomNumBetween0And10() {
        Random random = new Random();
        return random.nextInt(10-0+1) + 0;
    }

    public static char[][] generateCharArray() {
        char[][] randomCharArray = new char[5][5];
        Arrays.stream(randomCharArray).forEach(w -> {
            for (int i = 0; i < w.length; i++) {
                if (GenerateRandomNumBetween0And10() == 1) {
                    w[i] = '*';
                } else {
                    w[i] = '.';
                }
        }
        });

        return randomCharArray;
    }

    public static char[][] transformCharArrays(char[][] generatedCharArray ) {
        Arrays.stream(generatedCharArray).forEach(w -> {
            if (generateCharArray()[-1][2] == 0) {
                System.out.println("lol");
            }

        });
        return new char[1][1];
    }

    public static void main(String[] args) {


        Arrays.stream(generateCharArray()).forEach(w -> System.out.println(w));
        transformCharArrays(generateCharArray());
    }
}
