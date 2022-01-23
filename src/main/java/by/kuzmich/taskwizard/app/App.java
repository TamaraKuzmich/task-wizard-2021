package by.kuzmich.taskwizard.app;

import by.kuzmich.taskwizard.model.*;
import by.kuzmich.taskwizard.util.TaskCreator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class App {

    public static void main(String[] args) {

        final Scanner SCANNER = new Scanner(in);
        final String YES_ANSWER = "Y";
        final String REPLY_IF_NO = "OK. You can do it later.";

        List<Task> tasks = new ArrayList<>();

        // some tasks to add to collection and see if
        // sorting and filtering are performed well
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

        // to add new task and check if task with the same name
        // won't be added to collection
        out.println("Would you like to add a new task? Y/N");
        String answerIfAdd = SCANNER.nextLine();
        if (answerIfAdd.equalsIgnoreCase(YES_ANSWER)) {
            out.println("Enter the name of your task: ");
            String newTaskName = SCANNER.nextLine();

            // здесь должна быть проверка, но что-то она как-то не получилась
            if (tasks.stream()
                    .map(Task::getTaskName).noneMatch(Predicate.isEqual(newTaskName))) {
                Task newTask = TaskCreator.create(newTaskName);
                tasks.add(newTask);
            } else {
                out.println("This task already exists.");
            }

        } else out.println(REPLY_IF_NO);


        // part with different kinds of sorting
        out.println("Would you like to sort your tasks? Y/N");
        String answerIfSort = SCANNER.nextLine();
        if (answerIfSort.equalsIgnoreCase(YES_ANSWER)) {
            sortingTasks(SCANNER, tasks);
        } else {
            out.println(REPLY_IF_NO);
        }

        // part with filtering
        /* toDo: when the result of filtering is null, you need to inform user about it.
         */
        out.println("Would you like to choose tasks with certain conditions? Y/N");
        String answerIfFilter = SCANNER.nextLine();
        if (answerIfFilter.equalsIgnoreCase(YES_ANSWER)) {
            filteringTasks(SCANNER, tasks);
        } else {
            out.println(REPLY_IF_NO);
        }

        //part with task names
        out.println("Would you like to see a list of your tasks' names? Y/N");
        String answerIfSeeNames = SCANNER.nextLine();
        if (answerIfSeeNames.equalsIgnoreCase(YES_ANSWER)) {
            printAllTaskNames(tasks);
        } else out.println(REPLY_IF_NO);

    }

    private static void filteringTasks(Scanner SCANNER, List<Task> tasks) {
        out.println("Choose condition: " +
                "for \"category\" enter 1, for \"priority\" enter 2");
        int answerFilterCondition = SCANNER.nextInt();
        SCANNER.nextLine();

        switch (answerFilterCondition) {
            case 1: {
                out.println("Choose category: \n\r0 means \"Work\", \n\r1 means \"Study\", \n\r2 means \"Family\", \n\r3 means \"Household\", \n\r4 means \"Shopping\", \n\r5 means \"Sports\", \n\r6 means \"Personal\", \n\r7 means \"Other\":\n\r");
                int filterConditionNum = SCANNER.nextInt();
                SCANNER.nextLine();
                out.println(
                        tasks.stream().
                                filter(task -> task.getCategory() == Category.parse(filterConditionNum)).
                                map(Task::toString).
                                collect(Collectors.joining("\n______________________________________\n",
                                        "Your tasks:\n", "\n"))
                );
                break;
            }
            case 2: {
                out.println("Choose priority: \n\r0 means \"High priority\", \n\r1 means \"Regular\", \n\r2 means \"Low priority\"");
                int filterConditionNum = SCANNER.nextInt();
                SCANNER.nextLine();
                out.println(
                        tasks.stream().
                                filter(task -> task.getPriority() == Priority.parse(filterConditionNum)).
                                map(Task::toString).
                                collect(Collectors.joining("\n______________________________________\n",
                                        "Your tasks:\n", "\n"))
                );
                break;
            }
            default:
                out.println("There is no such criteria to choose");
        }

    }

    private static void sortingTasks(Scanner SCANNER, List<Task> tasks) {
        out.println("Choose condition: " +
                "for \"task name\" enter 0, for \"category\" enter 1, for \"priority\" enter 2");
        int answerConditionNumber = SCANNER.nextInt();
        SCANNER.nextLine();

        switch (answerConditionNumber) {
            case 0: {
                tasks.sort(Task::compareTo);
                printTasks(tasks);
                break;
            }
            case 1: {
                tasks.sort(Comparator.comparing(Task::getCategory));
                printTasks(tasks);
                break;
            }
            case 2: {
                tasks.sort(Comparator.comparing(Task::getPriority));
                printTasks(tasks);
                break;
            }
            default:
                out.println("There is no such criteria");
        }
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


