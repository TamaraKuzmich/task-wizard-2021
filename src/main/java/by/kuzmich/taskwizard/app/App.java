package by.kuzmich.taskwizard.app;

import by.kuzmich.taskwizard.model.*;
import by.kuzmich.taskwizard.util.OneTimeTaskCreator;
import by.kuzmich.taskwizard.util.RepeatableTaskCreator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class App {

    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();

        OneTimeTask oneTimeTask = OneTimeTaskCreator.create();
        tasks.add(oneTimeTask);

        out.println();

        OneTimeTask oneTimeTask1 = new OneTimeTask("buy present for Dad",
                Priority.HIGH_PRIORITY, Category.SHOPPING,
                "2022-02-22");
        tasks.add(oneTimeTask1);

        OneTimeTask oneTimeTask2 = new OneTimeTask("buy present for Dad",
                Priority.HIGH_PRIORITY, Category.SHOPPING,
                "2022-02-22");
        tasks.add(oneTimeTask2);

        RepeatableTask repeatableTask = RepeatableTaskCreator.create();
        tasks.add(repeatableTask);

        RepeatableTask repeatableTask1 = new RepeatableTask("swipe the floor",
                Priority.LOW_PRIORITY,
                Category.HOUSEHOLD, "2022-01-05", "3 days",
                "2022-01-08");
        tasks.add(repeatableTask1);

        out.println(oneTimeTask1.hashCode());
        out.println(oneTimeTask2.hashCode());
        out.println(repeatableTask1.hashCode());
        out.println();

        out.println();
        tasks.sort(Task::compareTo);
        printTasks(tasks);

    }

    private static void printTasks(List<Task> tasks) {
        out.println("Your tasks:");
        out.println("______________________________________");
        for (Task task : tasks) {
            out.println(task);
            out.println("______________________________________");
        }
    }


}


