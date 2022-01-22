package by.kuzmich.taskwizard.app;

import by.kuzmich.taskwizard.model.*;
import by.kuzmich.taskwizard.util.TaskCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class App {

    public static void main(String[] args) {

        final Scanner SCANNER = new Scanner(in);
        final String YES_ANSWER = "Y";


        List<Task> tasks = new ArrayList<>();

        // part with adding new task

        out.println("Would you like to add a new task? Y/N");
        String answerIfAdd = SCANNER.nextLine();

        if (answerIfAdd.equalsIgnoreCase(YES_ANSWER)) {
            Task task = TaskCreator.create();
            if (!tasks.contains(task)) { //doesn't work
                tasks.add(task);
                out.println();
            } else {
                out.println("Task with such name is already created.");
            }
        } else out.println("OK. You can do it later.");


        OneTimeTask oneTimeTask1 = new OneTimeTask("buy present for Dad",
                Priority.HIGH_PRIORITY, Category.SHOPPING,
                "2022-02-22");
        tasks.add(oneTimeTask1);

        OneTimeTask oneTimeTask2 = new OneTimeTask("buy present for Dad",
                Priority.HIGH_PRIORITY, Category.SHOPPING,
                "2022-02-22");
        tasks.add(oneTimeTask2);

        RepeatableTask repeatableTask1 = new RepeatableTask("swipe the floor",
                Priority.LOW_PRIORITY,
                Category.HOUSEHOLD, "2022-01-05", "3 days");
        tasks.add(repeatableTask1);

        // part with different kinds of sorting

        out.println("Would you like to sort your tasks? Y / N");
        String answerIfSort = SCANNER.nextLine();
        if (answerIfSort.equalsIgnoreCase(YES_ANSWER)) {
            out.println("Choose condition: " +
                    "for \"task name\" enter 0, for \"category\" enter 1, for \"priority\" enter 2");
            int answer2 = SCANNER.nextInt();
            switch (answer2) {
                case 0: {
                    tasks.sort(Task::compareTo);
                    printTasks(tasks);
                    break;
                }
                case 1: {
                    CategoryComparator categoryComparator = new CategoryComparator();
                    tasks.sort(categoryComparator);
                    printTasks(tasks);
                    break;
                }
                case 2: {
                    PriorityComparator priorityComparator = new PriorityComparator();
                    tasks.sort(priorityComparator);
                    printTasks(tasks);
                    break;
                }
                default:
                    out.println("There is no such criteria");
            }
        } else {
            out.println("OK. You can do it later.");
        }

        // part with filtering tasks

        //part with task names

        out.println("Would you like to see a list of your tasks' names?");
        String answerIfSeeNames = SCANNER.nextLine();
        if (answerIfSeeNames.equalsIgnoreCase(YES_ANSWER)){
            printAllTaskNames(tasks);
        }
        else out.println("OK. See you next day.");

    }


    private static void printTasks(List<Task> tasks) {
        out.println("Your tasks:");
        out.println("______________________________________");
        for (Task task : tasks) {
            out.println(task);
            out.println("______________________________________");
        }
    }

    private static void printAllTaskNames(List<Task> tasks) {
        String allTaskNames = tasks.stream()
                .map(Task::getTaskName)
                .collect(Collectors.joining("\n",
                        "Here are the names of your tasks:\n", "\n"));
        out.println(allTaskNames);
    }


}


