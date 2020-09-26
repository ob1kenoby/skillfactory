package com.skillfactory.module13;

import java.io.*;
import java.util.Scanner;

public class Task13_3_4 {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter a line of text:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        File file = new File("13_3_4.txt");
        if (!file.exists()) {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } else {
            System.out.println("Такой файл существует, куда бы Вы хотели добавить текст. Нажмите 1, чтобы добавить в " +
                    "начало, нажмите 2, чтобы добавить в конец, enter 3 to exit");
            int choice = 0;
            while (!(choice == 1 || choice == 2 || choice == 3)) {
                choice = scanner.nextInt();
            }
            if (choice == 1) {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String fileContent = reader.readLine();
                fileReader.close();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(text);
                fileWriter.write(fileContent);
                fileWriter.close();
            } else if (choice == 2) {
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write(text);
                fileWriter.close();
            }
        }
    }
}
