package com.skillfactory.module13;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Task13_4_1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localIP = InetAddress.getLocalHost();
        InetAddress skidata = InetAddress.getByName("skidata.com");
        System.out.println(localIP);
        System.out.println(skidata);
    }
}
