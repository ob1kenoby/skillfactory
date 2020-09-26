package com.skillfactory.module11;

public class trainer11_2 {
    public static void main(String[] args) {
        int[] array = {15, 34, 5, 3, -11, 567, 2, 547, 2, 0, -12, 35};
        int number = 567;
        int index = getFirstIndex(array, number);
        System.out.println("Index of number in array = " + index);

        printOdd(array); //Добавить этот метод
        System.out.println();
        printEvenIndex(array); //Добавить этот метод
    }

    private static void printEvenIndex(int[] array) {
        for (int number : array) {
            if (number !=0 && number % 2 == 0) {
                System.out.println(number);
            }
        }
    }

    private static void printOdd(int[] array) {
        for (int number : array) {
            if (Math.abs(number % 2) == 1) {
                System.out.println(number);
            }
        }
    }

    private static int getFirstIndex(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
