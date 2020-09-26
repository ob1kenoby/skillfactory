package com.skillfactory.module12.studentBook;

public class Student extends Person {
    int tasksSolved;
    static int overallTaskSolved;
    Mentor mentor;
    boolean solvedAll;

    public Student(String firstName, String lastName, int age, Mentor mentor, boolean solvedAll) {
        super(firstName, lastName, age);
        this.mentor = mentor;
        this.solvedAll = solvedAll;
        this.tasksSolved = 0;
    }

    public void solveTasks(int amount, Task[] tasks) {
        while (this.getTasksSolved() < tasks.length && amount > 0) {
            solveTask(tasks[this.getTasksSolved()]);
            System.out.printf("Solved %d tasks out of %d \n", this.getTasksSolved(), tasks.length);
            amount -= 1;
        }
        if (this.getTasksSolved() >= tasks.length) {
            System.out.println("All tasks completed");
            setSolvedAll(true);
        }
    }

    private void solveTask(Task task) {
        if (task instanceof Autochecked) {
            System.out.println("Task complete");
        } else {
            boolean accepted = false;
            while (!accepted) {
                accepted = mentor.checkCode(task);
            }
        }
        this.incrementTasks();
    }

    public void incrementTasks() {
        this.setTasksSolved(this.getTasksSolved() + 1);
        Student.setOverallTaskSolved(Student.getOverallTaskSolved() + 1);
    }

    public int getTasksSolved() {
        return tasksSolved;
    }

    public void setTasksSolved(int tasksSolved) {
        this.tasksSolved = tasksSolved;
    }

    public static int getOverallTaskSolved() {
        return overallTaskSolved;
    }

    public static void setOverallTaskSolved(int overallTaskSolved) {
        Student.overallTaskSolved = overallTaskSolved;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public boolean isSolvedAll() {
        return solvedAll;
    }

    public void setSolvedAll(boolean solvedAll) {
        this.solvedAll = solvedAll;
    }
}
