package com.skillfactory.module13;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Task13_4_3 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http", "mirror.tversu.ru", 80,
                "/centos/8.2.2004/isos/x86_64/CentOS-8.2.2004-x86_64-boot.iso");
        URLConnection connection = url.openConnection();
        int fileSize = connection.getContentLength();
        BufferedInputStream in = new BufferedInputStream(url.openStream());
        FileOutputStream out = new FileOutputStream("centos.iso");
        byte[] dataBuffer = new byte[16384];
        int bytesRead;
        int downloaded = 0;
        int updateCount = 0;
        int[] process = new int[100];
        String progress = "";
        int percent = 0;
        for (int i = 0; i < 100; i++) {
            process[i] = (int) (fileSize * (i / 100.0));
        }
        while ((bytesRead = in.read(dataBuffer, 0, 16384)) != -1) {
            out.write(dataBuffer, 0, bytesRead);
            out.flush();
            downloaded += bytesRead;
            if (updateCount == 100) {
                for (int i = percent; i < 100; i++) {
                    if (downloaded <= process[i]) {
                        progress = createProgressBar(i);
                        percent = i;
                        break;
                    }
                }
                System.out.printf("Downloading: %d out of %d (%d%%)\n", downloaded, fileSize, percent);
                System.out.println(progress);
                updateCount = 0;
            } else {
                updateCount += 1;
            }
        }
        in.close();
        out.close();
    }

    private static String createProgressBar(int i) {
        char[] progress = new char[100];
        Arrays.fill(progress, 0, i, '=');
        Arrays.fill(progress, i + 1, progress.length, ' ');
        return "[" + new String(progress) + "]";
    }
}
