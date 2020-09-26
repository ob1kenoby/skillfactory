package com.skillfactory.module13;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class Task13_4_2 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http","185.165.123.206", 80, "/");
        URLConnection connection = url.openConnection();
        System.out.println(connection.getURL());
        byte[] address = {(byte) 185, (byte) 165, 123, (byte) 206};
        InetAddress test = InetAddress.getByAddress("SkillFactory", address);
        System.out.println(test.isReachable(1000));
        System.out.println(test.getHostName());
        System.out.println(test.getAddress());
    }
}
