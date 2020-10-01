package com.skillfactory.module16;

import java.time.LocalTime;

public class Demo16_1 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(16, 30); // строка 1
        System.out.println(time.withHour(14).plusMinutes(15));
        System.out.println(time);
    }
}
