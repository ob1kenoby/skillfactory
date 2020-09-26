package com.skillfactory.module13;

import java.util.Scanner;

public class Task13_1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a: ");
        double a = scanner.nextDouble();
        System.out.print("Input b: ");
        double b = scanner.nextDouble();
        System.out.print("Input c: ");
        double c = scanner.nextDouble();
        String x1 = "x1 = %.0f\n";
        String x2 = "x2 = %.0f\n";
        if (a == 0) {
            System.out.printf(x1, (0.0 - c) / b);
        } else if (b == 0) {
            System.out.printf(x1, Math.sqrt((0 - c) / a));
        } else if (c == 0) {
            System.out.printf(x1, 0.0);
            System.out.printf(x2, (0 - b) / a);
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                System.out.println("The equation doesn't have any rational solutions");
            } else if (d == 0) {
                System.out.printf(x1, (0 - b) / (2 * a));
            } else {
                System.out.printf(x1, ((0 - b) - Math.sqrt(d)) / (2 * a));
                System.out.printf(x2, ((0 - b) + Math.sqrt(d)) / (2 * a));
            }
        }
    }
}
