package com.skillfactory.module15;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        int numberOfTasks = 5;
        Deque toDoQueue = new ArrayDeque(numberOfTasks);
        Boss boss = new Boss(toDoQueue);
        Worker worker = new Worker(toDoQueue);
        for (int i = 1; i <= numberOfTasks; i++) {
            boss.giveTask("Задание " + i);
        }
        System.out.println("Начальник закончил давать задания");
        for (int i = 1; i <= numberOfTasks; i++) {
            worker.takeTask();
        }
    }
}