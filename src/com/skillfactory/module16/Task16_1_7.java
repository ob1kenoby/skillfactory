package com.skillfactory.module16;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Task16_1_7 {
    public static LocalTime convertDateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return zonedDateTime.toLocalTime();
    }

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(convertDateToLocalTime(date));
    }
}
