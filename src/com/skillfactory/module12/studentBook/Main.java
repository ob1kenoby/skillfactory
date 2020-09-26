package com.skillfactory.module12.studentBook;

import java.util.Random;

public class Main {
    final private static Random random = new Random();

    public static void main(String[] args) {
        Task[] tasks = createTasks(30);
        Mentor youngMentor = new Mentor("Иван", "Сидоров", 19);
        Mentor oldMentor = new Mentor("Иерикон", "Осипович", 87);
        Student[] students = {
                new Student("Мансур", "Юсуфов", 30, youngMentor, false),
                new Student("Остап", "Бендер", 35, youngMentor, false),
                new Student("Леонид", "Брежнев", 80, oldMentor, false),
                new Student("Илья", "Муромец", 33, oldMentor, false),
        };
        for (Student student: students) {
            while (!student.isSolvedAll()) {
                int taskAmount = random.nextInt(30);
                System.out.printf("Attempt for %s %s, solving %d tasks\n",
                        student.getFirstName(), student.getLastName(), taskAmount);
                student.solveTasks(taskAmount, tasks);
            }
        }
    }

    private static Task[] createTasks(int size) {
        Task[] tasks = new Task[size];
        int taskType;
        for (int j = 0; j < size; j++) {
            taskType = random.nextInt(3);
            switch (taskType) {
                case 0 -> tasks[j] = new Test();
                case 1 -> tasks[j] = new DragAndDrop();
                case 2 -> tasks[j] = new Code();
            }
        }
        return tasks;
    }
}
