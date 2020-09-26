package com.skillfactory.module11;

import java.util.Scanner;

public class Task11_2_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte hier Ihre Telefonnummer shreiben:");
        String rawNumber = scanner.nextLine();
        String phoneNumber = parseNumber(rawNumber);
        System.out.println(phoneNumber);
    }

    private static String parseNumber(String rawNumber) {
        rawNumber = rawNumber.replaceAll("\\D+", "");
        rawNumber = rawNumber.substring(rawNumber.length() - 10);
        String code = rawNumber.substring(0, 3);
        String first = rawNumber.substring(3, 6);
        String second = rawNumber.substring(6, 8);
        String third = rawNumber.substring(8);
        String number = String.format("+7 %s %s %s %s", code, first, second, third);
        return number;
    }
}
