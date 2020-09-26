package com.skillfactory.module15;

import java.util.ArrayList;

public class Task15_4_6 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        int temp;
        for (int i = 0; i < 50; i++) {
            temp = list.get(i);
            list.set(i, list.get(99 - i));
            list.set(99 - i, temp);
        }
        System.out.println(list);
    }
}
