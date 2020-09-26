package com.skillfactory.module11;

import java.util.Arrays;

public class trainer11_1 {
    public static void main(String[] args) {
        int[] array = {15, 34, 5, 3, -11, 567, 2, 547, 2, 0, -12, 35};
        int min = getMin(array);
        int max = getMax(array);
        System.out.println("Minimal value = " + min + " and maximum value = " + max);
    }

    private static int getMin(int[] array) {
        int min = 0;
        for (int number : array) {
            min = Math.min(number, min);
        }
        return min;
    }

    private static int getMax(int[] array) {
        int[] temp = new int[array.length];
        System.arraycopy(array, 0, temp, 0, array.length);
        Arrays.sort(temp);
        return temp[temp.length - 1];
    }
}