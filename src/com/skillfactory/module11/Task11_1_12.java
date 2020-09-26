package com.skillfactory.module11;

public class Task11_1_12 {
    public static void main(String[] args) {
        String[][] checkmate = new String[8][8];
        boolean black = false;
        for (int i = 0; i < 8; i++) {
            black = !black; // Чтобы каждый ряд начинался с другого цвета
            for (int j = 0; j < 8; j++) {
                checkmate[i][j] = (black) ? "Black" : "White";
                black = !black;
            }
        }
        print2DArray(checkmate);
    }

    public static void print2DArray(String[][] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                str = str + array[i][j] + " ";
            }
            System.out.println(str);
            str = "";
        }
    }

}
