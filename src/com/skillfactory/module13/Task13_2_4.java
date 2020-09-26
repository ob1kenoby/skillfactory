package com.skillfactory.module13;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task13_2_4 {
    public static void main(String[] args) {
        Calendar today = new GregorianCalendar();
        Calendar nextYear = new GregorianCalendar();
        nextYear.set(Calendar.MONTH, Calendar.AUGUST);
        nextYear.set(Calendar.DAY_OF_MONTH, 14);
        nextYear.add(Calendar.YEAR, 1);
        if (today.before(nextYear)) {
//            LocalDate todayLocal = LocalDate.ofInstant(today.toInstant(), ZoneId.systemDefault());
//            LocalDate nextYearLocal = LocalDate.ofInstant(nextYear.toInstant(), ZoneId.systemDefault());
            long todayDate = today.getTime().getTime();
            long nextYearDate = nextYear.getTime().getTime();
            long difference = (nextYearDate - todayDate) / 1000 / 60 / 60 / 24;
            int dif = (int) difference;
            System.out.println(dif);
        }
    }
}
