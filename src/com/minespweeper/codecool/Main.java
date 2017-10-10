package com.minespweeper.codecool;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static char mineField[][];

    public static int GenerateRandomNumBetween0And11() {
        Random random = new Random();
        return random.nextInt(11-0+1) + 0;
    }

    public static void generateCharArray() {
        char[][] randomCharArray = new char[5][5];
        Arrays.stream(randomCharArray).forEach(w -> {
            for (int i = 0; i < w.length; i++) {
                if (GenerateRandomNumBetween0And11() % 5 == 0) {
                    w[i] = '*';
                } else {
                    w[i] = '.';
                }
        }
        });

        mineField = randomCharArray;
    }
    public static int mineAt(int y, int x) {
        if(y >= 0 && y < 5 && x >= 0 && x < 5 && mineField[y][x] == '*') {
            return 1;
        } else {
            return 0;
        }
    }

    public static char minesNear(int y, int x) {
        int mines = 0;
        // check mines in all directions
        mines += mineAt(y - 1, x - 1);
        mines += mineAt(y - 1, x);
        mines += mineAt(y - 1, x + 1);
        mines += mineAt(y, x - 1);
        mines += mineAt(y, x + 1);
        mines += mineAt(y + 1, x - 1);
        mines += mineAt(y + 1, x);
        mines += mineAt(y + 1, x + 1);
        if(mines > 0) {
            return (char)(mines+ 48);
        } else {
            return '0';
        }
    }

    public static void transformCharArrays(char[][] generatedCharArray ) {
        for (int i = 0; i < generatedCharArray.length; i++) {
            for (int k = 0; k < generatedCharArray[i].length; k++) {
                if(mineField[i][k] != '*') {
                    mineField[i][k] = minesNear(i, k);
                }
            }

        }
    }

    public static void printTables(char[][] table) {
        Arrays.stream(table).forEach(t -> System.out.println(t));
    }


    public static void main(String[] args) {

        generateCharArray();
        printTables(mineField);
        transformCharArrays(mineField);
        printTables(mineField);
    }
}
