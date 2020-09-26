package com.skillfactory.module12.studentBook;

public interface Autochecked {
    default void completeTask() {
        System.out.println("Task complete");
    }
}
