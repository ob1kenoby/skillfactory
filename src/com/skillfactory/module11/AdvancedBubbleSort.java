package com.skillfactory.module11;

public class AdvancedBubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 0, 6, 10, 340, 5, 6, 20, 25, 50, 8, 7, 3, 44, 1, 1, 0, 6, 4};
        printInLine(bubbleSort(array));
    }

    private static int[] bubbleSort(int[] array) {
        boolean changed = true;
        while (changed) {
            changed = false; // если массив уже отсортирован, то не будет дальше выполняться
            for (int i = 1; i < array.length; i++) {
                if (array[i-1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    changed = true;
                    break;
                }
            }
        }
        return array;
    }

    private static void printInLine(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result = result + array[i] + " "; //Конкатенация строк
        }
        System.out.println(result);
    }
}

