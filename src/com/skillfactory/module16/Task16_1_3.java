package com.skillfactory.module16;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Task16_1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int minutes = scanner.nextInt();
        LocalTime time = LocalTime.of(hour, minute);
        Duration duration = Duration.ofMinutes(minutes);
        LocalTime now = LocalTime.now();
        System.out.println(now.isBefore(time.plus(duration)));
    }
}
