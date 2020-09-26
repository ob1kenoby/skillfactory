package com.skillfactory.module11.phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    final static Scanner SCANNER = new Scanner(System.in);
    final static String CSV_PATH = ".\\PhoneBook.csv";

    public static void main(String[] args) {
        String[][] phoneBook = readFromDrive();
        boolean continueRunning = true;
        while (continueRunning){
            printIntro();
            String userInput = getInput();
            boolean inputCorrect = false;
            if ("exit".equals(userInput)) {
                continueRunning = false;
            } else if ("print".equals(userInput)) {
                printContent(phoneBook);
            } else {
                String name = userInput.replaceAll("[^а-яА-ЯёЁ ]", "").trim();
                String phoneNumber = userInput.replaceAll("[\\D+]", "");
                if (name.length() > 0 && phoneNumber.length() > 0) { // Проверка если были введены и текст, и цифры
                    inputCorrect = checkBothConditions(name, phoneNumber);
                    if (inputCorrect) {
                        phoneBook = addEntry(phoneBook, name, phoneNumber);
                    }
                } else if (name.length() > 0) {
                    inputCorrect = checkName(name);
                    if (inputCorrect) {
                        name = formatName(name);
                        boolean foundUser = findByName(phoneBook, name);
                        if (!foundUser) {
                            phoneBook = addEntryByName(phoneBook, name);
                        }
                    }
                } else if (phoneNumber.length() > 0) {
                    inputCorrect = checkPhoneNumber(phoneNumber);
                    if (inputCorrect) {
                        phoneNumber = formatPhoneNumber(phoneNumber);
                        boolean foundUser = findByPhone(phoneBook, phoneNumber);
                        if (!foundUser) {
                            phoneBook = addEntryByPhone(phoneBook, phoneNumber);
                        }
                    }
                }
                if (!inputCorrect) {
                    System.out.println("Ошибка ввода. Попробуйте ещё раз.");
                }
            }
        }
    }

    private static String[][] addEntryByPhone(String[][] phoneBook, String number) {
        System.out.printf("Не найдено записей для %s.\n", number);
        System.out.println("Для добавления введите ФИО.");
        System.out.println("Для отмены введите 'cancel'.");
        String input = getInput().toLowerCase();
        if ("cancel".equals(input)) {
            return phoneBook;
        }
        String name = input.replaceAll("[^а-яА-ЯёЁ ]", "");
        phoneBook = addEntry(phoneBook, name, number);
        return phoneBook;
    }

    private static boolean findByPhone(String[][] phoneBook, String phoneNumber) {
        return findWithArrayIndex(phoneBook, phoneNumber, 1);
    }

    private static boolean findWithArrayIndex(String[][] phoneBook, String data, int i) {
        for (String[] row : phoneBook) {
            if (data.equals(row[i])) {
                printEntry(row);
                return true;
            }
        }
        return false;
    }

    private static String[][] addEntryByName(String[][] phoneBook, String name) {
        System.out.printf("Не найдено записей для %s.\n", name);
        System.out.println("Для добавления введите номер телефона в любом формате.");
        System.out.println("Для отмены введите 'cancel'.");
        String input = getInput().toLowerCase();
        if ("cancel".equals(input)) {
            return phoneBook;
        }
        String number = input.replaceAll("[\\D+]", "");
        phoneBook = addEntry(phoneBook, name, number);
        return phoneBook;
    }

    private static boolean checkBothConditions(String name, String phoneNumber) {checkName(name);
        if (checkName(name)) {
            return checkPhoneNumber(phoneNumber);
        }
        return false;
    }

    private static boolean findByName(String[][] phoneBook, String name) {
        return findWithArrayIndex(phoneBook, name, 0);
    }

    private static String[][] readFromDrive() {
        //Don't like the solution for this method but have too little experience to do that cleaner
        List<String[]> records = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(CSV_PATH))) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                records.add(row.split(";"));
            }
            String[][] phoneBook = new String[records.size()][2];
            records.toArray(phoneBook);
            return phoneBook;
        } catch (FileNotFoundException fileNotFound) {
                System.err.println("File PhoneBook.csv not found" + fileNotFound);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0][2];
    }

    private static void printIntro() {
        System.out.println();
        System.out.println("Для внесения в телефонным справочник введите ФИО и номер телефона в любом формате.");
        System.out.println("Для поиска по телефонному справочнику введите имя или номер телефона.");
        System.out.println("Для выхода наберите exit.");
        System.out.println("Для печати всей книги напишите print.");
    }

    private static String getInput() {
        System.out.print("> ");
        return SCANNER.nextLine().trim();
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.length() >= 10;
    }

    public static boolean checkName(String name) {
        return name.trim().split(" ").length == 3; // True if three words.
    }

    public static String formatName(String s) {
        String[] name = correctCaseFormatting(s.trim().split(" "));
        return String.format("%s %s %s", name[0], name[1], name[2]);
    }

    private static String[] correctCaseFormatting(String[] words) {
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return words;
    }

    public static String formatPhoneNumber(String number) {
        number = number.replaceAll("[\\D+]", ""); //REPLACE ALL REGEX KILL PROBELL
        number = number.substring(number.length() - 10);
        String code = number.substring(0, 3);
        String first = number.substring(3, 6);
        String second = number.substring(6, 8);
        String third = number.substring(8);
        return String.format("8 %s %s %s %s", code, first, second, third);
    }

    public static String[][] addEntry(String[][] book, String name, String number) {
        name = formatName(name);
        number = formatPhoneNumber(number);
        String[][] newBook = new String[book.length + 1][2];
        System.arraycopy(book, 0, newBook, 0, book.length);
        newBook[book.length][0] = name;
        newBook[book.length][1] = number;
        writeToDrive(newBook);
        System.out.println("Добавлена запись:");
        printEntry(newBook[newBook.length - 1]);
        return newBook;
    }

    private static void writeToDrive(String[][] newBook) {
        try (FileWriter csvWriter = new FileWriter(CSV_PATH)) {
            for (String[] row : newBook) {
                csvWriter.append(String.format("%s;%s\n", row[0], row[1]));
            }
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printContent(String[][] book) {
        int[] index = sortBook(book);
        for (int i : index) {
            printEntry(book[i]);
        }
    }

    private static int[] sortBook(String[][] book) {
        int[] index = new int[book.length];
        for (int i = 0; i < book.length; i++) {
            index[i] = i;
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 1; i < book.length; i++) {
                char a = book[index[i-1]][0].charAt(0);
                char b = book[index[i]][0].charAt(0);
                if (a > b) {
                    int temp = index[i];
                    index[i] = index[i-1];
                    index[i-1] = temp;
                    changed = true;
                }
            }
        }
        return index;
    }

    private static void printEntry(String[] entry) {
        System.out.printf("%s\t%s\n", entry[0], entry[1]);
    }
}
