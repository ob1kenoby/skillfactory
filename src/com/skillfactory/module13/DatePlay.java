package com.skillfactory.module13;

import java.util.Date;

public class DatePlay {
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        Date nanoDate = new Date(System.nanoTime());
        System.out.println(nanoDate);
        Date checkGetDate = new Date();
        System.out.println(checkGetDate.getTime());
    }
}
