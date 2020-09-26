package com.skillfactory.module13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task13_3_2 {
    public static void main(String[] args) {
        File file = new File("text.txt");
        int spaceCount = 0;
        int i;
        boolean wasRead = false;
        try {
            FileReader fileReader = new FileReader(file);
            while ((i = fileReader.read()) != -1) {
                if ((char) i == ' ') {
                    spaceCount++;
                } else if (!wasRead) {
                    wasRead = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wasRead && spaceCount == 0) {
            System.out.println(0);
        } else {
            System.out.println(++spaceCount);
        }
    }
}
