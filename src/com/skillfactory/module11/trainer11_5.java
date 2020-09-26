package com.skillfactory.module11;

import java.util.Arrays;

public class trainer11_5 {
    public static void main(String[] args) {
        int[] array = createOddArray(1, 99);
//        System.out.println(Arrays.toString(array));
        //Написать код, заполняющий массив числами
        printInLine(array);
        String reverseArray = makeInLineReverseRecursive(array);
        System.out.println(reverseArray);
    }

    private static String makeInLineReverseRecursive(int[] array) {
        if (array.length == 1) {
            return String.valueOf(array[0]);
        }
        int[] temp = Arrays.copyOfRange(array, 0, array.length - 1);
        return array[array.length - 1] + " " + makeInLineReverseRecursive(temp);
    }


    private static int[] createOddArray(int start, int stop) {
        int[] result = new int[50];
        int j = start;
        for (int i = 0; i < result.length ; i++) {
            result[i] = j;
            j+=2;
        }
        return result;
    }

    private static int[] createOddArrayWithRecursion(int start, int stop) {
        if (start == stop) {
            int[] temp = {stop};
            return temp;
        } else {
            int[] temp1 = createOddArray(start + 2, stop);
            int[] temp2 = {start};
            int[] temp3 = Arrays.copyOf(temp2, 1 + temp1.length);
            System.arraycopy(temp1, 0, temp3, 1, temp1.length);
            return temp3;
        }
    }

    private static void printInLineReverse(int[] array) {
        String toPrint = "";
        for (int i = array.length - 1; i >= 0; i--) {
            toPrint += array[i] + " ";
        }
        System.out.println(toPrint);
    }

    //Метод печатает элементы массива в строку
    private static void printInLine(int[] array) {
        String result = "";
        for (int num : array) {
            result += num + " "; //Конкатенация строк
        }
        System.out.println(result);
    }
}
