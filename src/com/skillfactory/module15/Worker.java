package com.skillfactory.module15;

import java.util.Deque;

public class Worker {
    private Deque toDoQueue;
    public Worker(Deque toDoQueue) {
        this.toDoQueue = toDoQueue;
    }
    public void takeTask() {
        Object task = toDoQueue.pop();
        if (task != null) {
            System.out.println("Выполняю задачу: " + task);
        } else {
            System.out.println("Нет работы! Можно идти домой");
        }
    }
}