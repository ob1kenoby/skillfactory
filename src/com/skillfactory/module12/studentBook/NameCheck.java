package com.skillfactory.module12.studentBook;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameCheck {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[А-Я][а-я]+(-[А-Я][а-я]+)*\\s[А-Я][а-я]+\\s[А-Я][а-я]+");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            System.out.println("Name is correct");
        } else {
            System.out.println("Name is incorrect");
        }
    }
}
