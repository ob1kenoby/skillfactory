package com.skillfactory.module12.studentBook;

import java.util.Random;

public class Mentor extends Person implements Staff{
    boolean goodMood;
    final Random random = new Random();

    public Mentor(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.goodMood = true;
    }

    public void helpStudent(Student student) {
        System.out.printf("You've got it, %s!\n", student.getFirstName());
    }

    boolean checkCode(Task task) {
        int currentMood = random.nextInt();
        if (currentMood > 1000) {
            System.out.println("Assignment accepted");
            return true;
        } else {
            System.out.printf("Task %d is not accepted\n", task.number);
            return false;
        }
    }
}
