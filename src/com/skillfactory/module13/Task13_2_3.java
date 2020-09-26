package com.skillfactory.module13;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task13_2_3 {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2019, 01, 15, 12, 20);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        System.out.println(dateFormat.format(date));
    }
}
