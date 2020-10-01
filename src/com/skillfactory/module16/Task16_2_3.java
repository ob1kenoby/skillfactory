package com.skillfactory.module16;

public class Task16_2_3 {
    public static double doubleFromInt(int value, Worker worker) {
        return worker.rework(value);
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println(doubleFromInt(x, i -> Double.valueOf(i)));
    }
}
