package com.skillfactory.module13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task13_3_3 {
    public static void main(String[] args) throws IOException {
        Calendar calendar = new GregorianCalendar();
        File file = new File("13_3_3.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        fw.write(String.valueOf(calendar.getTime()));
        fw.close();
    }
}
