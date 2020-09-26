package com.skillfactory.module11;

import java.util.Scanner;
import java.util.Arrays;

public class Task11_2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectName = false;
        while (!isCorrectName) {
            String name = scanner.nextLine(); //Считывает строку из System.in
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            } else {
                System.out.println(formatName(name));
            }
        }
    }

    private static String formatName(String name) {
        String[] words = name.split(" ");
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        words = uppercaseLetters(words);
        name = "";
        for (String word : words) {
            name += word + " ";
        }
        return name;
    }

    private static String[] uppercaseLetters(String[] words) {
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return words;
    }

    private static boolean checkName(String name) {
        String[] words = name.split(" ");
        return words.length == 3;
    }
}
