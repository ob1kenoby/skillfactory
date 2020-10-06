package com.skillfactory.module10;

import java.util.Scanner;

public class FirstCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0, b, result = 0;
        char operation;
        boolean clearResult = true, incorrectSymbol;
        mainLoop:
        while (true) {
            if (clearResult) {
                System.out.println("Введите первый операнд:");
                a = scanner.nextInt();
                result = a;
                clearResult = false;
            }
            do {
                incorrectSymbol = false;
                System.out.println("Введите действие или ? чтобы узнать список действий:");
                operation = scanner.next().charAt(0);
                switch (operation) {
                    case '?':
                        System.out.println("c - очистить результат последнего действия;\n" +
                                "s - выход;\n" +
                                "+ - сложение;\n" +
                                "- - вычитание;\n" +
                                "* - умножение;\n" +
                                "/ - целочисленное деление;\n" +
                                "^ - возведение в степень;\n" +
                                "? - вывод данной справки.");
                        break;
                    case 'c':
                    case 'C':
                        clearResult = true;
                        break;
                    case 's':
                    case 'S':
                        System.out.println("Выход");
                        break mainLoop;
                    case '+':
                        System.out.println("Введите второй операнд:");
                        b = scanner.nextInt();
                        result = addition(a, b);
                        break;
                    case '-':
                        System.out.println("Введите второй операнд:");
                        b = scanner.nextInt();
                        result = difference(a, b);
                        System.out.println(result);
                        break;
                    case '*':
                        System.out.println("Введите второй операнд:");
                        b = scanner.nextInt();
                        result = multiplication(a, b);
                        System.out.println(result);
                        break;
                    case '/':
                        System.out.println("Введите второй операнд:");
                        b = scanner.nextInt();
                        result = division(a, b);
                        System.out.println(result);
                        break;
                    case '^':
                        System.out.println("Введите степень:");
                        b = scanner.nextInt();
                        if (b < 0) {
                            System.out.println("Степень должна быть больше или равна 0.");
                        } else {
                            result = power(a, b);
                            System.out.println(result);
                        }
                        break;
                    default:
                        incorrectSymbol = true;
                        System.out.println("Введите корректную операцию или ? для вывода справки.");
                }
                a = result;
            } while (incorrectSymbol);
        }
    }

    private static int power(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        System.out.println(a + " ^ " + b + " = " + result);
        return result;
    }

    private static int division(int a, int b) {
        int result = a / b;
        System.out.println(a + " / " + b + " = " + result);
        return result;
    }

    private static int multiplication(int a, int b) {
        int result = a + b;
        System.out.println(a + " * " + b + " = " + result);
        return result;
    }

    private static int difference(int a, int b) {
        int result = a + b;
        System.out.println(a + " - " + b + " = " + result);
        return result;
    }

    private static int addition(int a, int b) {
        int result = a + b;
        System.out.println(a + " + " + b + " = " + result);
        return result;
    }
}
