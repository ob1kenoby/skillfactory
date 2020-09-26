package com.skillfactory.module13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Task13_6_1 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.print("Enter first date: DD.MM.YYYY: ");
        String rawDate1 = scanner.nextLine();
        System.out.print("Enter second date: DD.MM.YYYY: ");
        String rawDate2 = scanner.nextLine();
        Calendar date1 = new GregorianCalendar();
        Calendar date2 = new GregorianCalendar();
        date1.setTime(dateFormat.parse(rawDate1));
        date2.setTime(dateFormat.parse(rawDate2));
        long date1Long = date1.getTime().getTime();
        long date2Long = date2.getTime().getTime();
        long difference = (date2Long - date1Long) / 1000 / 60 / 60 / 24;
        int dif = Math.abs((int) difference);
        System.out.println(dif);
    }
}
