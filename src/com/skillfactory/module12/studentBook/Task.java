package com.skillfactory.module12.studentBook;

abstract class Task {
    int number;
    String taskText;

    public Task() {
        this.number = 0;
        this.taskText = "Текст задания";
    }
}
