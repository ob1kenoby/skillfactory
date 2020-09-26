package com.skillfactory.module15;

import java.util.Deque;

public class Boss {
    private Deque toDoQueue;
    public Boss(Deque toDoQueue) {
        this.toDoQueue = toDoQueue;
    }
    public void giveTask(String task) {
        toDoQueue.add(task);
        System.out.println("Дал задачу " + task);
    }
}