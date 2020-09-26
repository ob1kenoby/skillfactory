package com.skillfactory.module13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task13_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("две даты в виде дни/часы/минуты/секунды. Вторая дата позже по времени.");
        String rawDate1 = scanner.nextLine();
        String rawDate2 = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/HH/mm/ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = dateFormat.parse(rawDate1);
            date2 = dateFormat.parse(rawDate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date1.before(date2)) {
            long date1Epoch = date1.getTime();
            long date2Epoch = date2.getTime();
            long differenceEpoch = Math.abs(date2Epoch - date1Epoch);
            System.out.println(differenceEpoch);
            int days = (int) differenceEpoch / 1000 / 24 / 60 / 60;
            int hours = (int) differenceEpoch / 1000 / 60 / 60 - days * 24;
            int minutes = (int) differenceEpoch / 1000 / 60 - (days * 24 + hours) * 60;
            int seconds = (int) differenceEpoch / 1000 - ((days * 24 + hours) * 60 + minutes) * 60;
            System.out.printf("%S/%S/%S/%S", formatDate(days), formatDate(hours), formatDate(minutes),
                    formatDate(seconds));
//            Date difference = new Date(differenceEpoch);
//            System.out.println(dateFormat.format(difference));
        }
    }

    private static String formatDate(int date) {
        if (date < 10) {
            return String.format("0%d", date);
        } else {
            return String.format("%d", date);
        }
    }
}
