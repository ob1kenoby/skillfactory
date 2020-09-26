package com.skillfactory.module12.studentBook;

public interface Staff {
    void helpStudent(Student student);

    default void giveAdditionalResources() {
        System.out.println("http://habr.com");
    }
}
