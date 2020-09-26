package com.skillfactory.module11;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 0, 6, 10, 340, 5, 6, 0, 25, 0, 8, 7, 3, 44, 1, 1, 0, 6, 4};
        printInLine(moveZeros(array));
    }

    private static int[] moveZeros(int[] array) {
        int positionChange = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                for (int j = i + 1; j < array.length; j++) {
                    array[j-1] = array[j];
                    array[j] = 0;
                }
                positionChange++;
                if (array.length - i < positionChange) {
                    break;
                }
            }
        }
        return array;
    }

    private static int[] swapZeros(int[] array) {
        int frontPosition = 0;
        int endPosition = array.length - 1;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = frontPosition; i < endPosition; i++) {
                if (array[i] == 0) {
                    for (int j = endPosition; j >= frontPosition; j--) {
                        if (array[j] != 0) {
                            int temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                            changed = true;
                            frontPosition = i;
                            endPosition = j;
                            break;
                        }
                    }
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
