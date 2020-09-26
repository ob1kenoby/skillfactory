package com.skillfactory.module13;

import java.io.File;
import java.util.Scanner;

public class Task13_3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);
        int fileSize = (int) (file.length() / 1024 / 1024);
        System.out.printf("%d MB", fileSize);
    }
}
