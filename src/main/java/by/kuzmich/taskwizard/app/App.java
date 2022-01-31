package by.kuzmich.taskwizard.app;

import by.kuzmich.taskwizard.exception.IncorrectInputException;
import by.kuzmich.taskwizard.model.*;
import by.kuzmich.taskwizard.util.TaskCreator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class App {

    public static void main(String[] args) throws IOException {

        final Scanner SCANNER = new Scanner(in);

        List<Task> tasks = new ArrayList<>();
        // some tasks to add to collection and see if
        // sorting and filtering are performed well
        OneTimeTask oneTimeTask1 = new OneTimeTask("buy present for Dad",
                Priority.HIGH_PRIORITY, Category.SHOPPING,
                LocalDate.of(2022, Month.FEBRUARY, 22));
        tasks.add(oneTimeTask1);

        OneTimeTask oneTimeTask2 = new OneTimeTask("buy present for Dad",
                Priority.HIGH_PRIORITY, Category.SHOPPING,
                LocalDate.of(2022, Month.FEBRUARY, 22));
        tasks.add(oneTimeTask2);

        RepeatableTask repeatableTask1 = new RepeatableTask("swipe the floor",
                Priority.LOW_PRIORITY,
                Category.HOUSEHOLD,
                LocalDate.of(2022, Month.FEBRUARY, 22),
                Period.ofDays(7));
        tasks.add(repeatableTask1);


        out.println("Hello, this is your task wizard.\r\n" +
                "Here is the main menu of operations.");
        // toDo: when the result of filtering is null, you need to inform user about it.

        switchMenu(SCANNER, tasks);
        in.close();

    }

    private static void switchMenu(Scanner SCANNER, List<Task> tasks) {
        out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        out.println("Please choose an operation:\r\n" +
                "* to see a list of your task names, press 1\r\n" +
                "* to add a new task, press 2\r\n" +
                "* to sort your tasks, press 3\r\n" +
                "* to choose tasks with certain conditions, press 4\r\n" +
                "* to see how many time left to deadlines, press 5\r\n" +
                "* to end the session, press 6.");
        out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        try {
            int userChoice = receiveMenuChoice(SCANNER);
            switch (userChoice) {
                case 1: {
                    printAllTaskNames(SCANNER, tasks);
                    break;
                }
                case 2: {
                    createNewUniqueTask(SCANNER, tasks);
                    break;
                }
                case 3: {
                    sortTasks(SCANNER, tasks);
                    break;
                }
                case 4: {
                    filterTasks(SCANNER, tasks);
                    break;
                }
                case 5: {
                    showDaysToDeadline(SCANNER, tasks);
                    break;
                }

                case 6: {
                    out.println("Bye. See you later.");
                    break;
                }
                default: {
                    throw new IncorrectInputException();
                }
            }
        } catch (NumberFormatException | IncorrectInputException e) {
            out.println(e.getMessage());
        }
    }

    public static int receiveMenuChoice(Scanner SCANNER) throws NumberFormatException {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("You didn't enter number.");
        }
    }

    private static void printAllTaskNames(Scanner SCANNER, List<Task> tasks) {
        String allTaskNames = tasks.stream()
                .map(Task::getTaskName)
                .collect(Collectors.joining("\n>>> ",
                        "Here are the names of your tasks:\n>>> ", "\n"));
        out.println(allTaskNames);
        switchMenu(SCANNER, tasks);
    }

    private static void createNewUniqueTask(Scanner SCANNER, List<Task> tasks) {
        out.println("Enter the name of your task: ");
        String newTaskName = SCANNER.nextLine();

        if (tasks.stream()
                .map(Task::getTaskName).noneMatch(Predicate.isEqual(newTaskName))) {
            Task newTask = TaskCreator.create(newTaskName);
            tasks.add(newTask);
            switchMenu(SCANNER, tasks);
        } else {
            out.println("This task already exists.");
        }
        switchMenu(SCANNER, tasks);
    }

    private static void printTasks(List<Task> tasks) {
        out.println("Your tasks:");
        out.println("______________________________________");
        for (Task task : tasks) {
            out.println(task);
            out.println("______________________________________");
        }
    }

    private static void sortTasks(Scanner SCANNER, List<Task> tasks) {
        out.println("Choose condition: " +
                "for \"task name\" enter 0, for \"category\" enter 1, for \"priority\" enter 2");
        int answerConditionNumber = receiveMenuChoice(SCANNER);
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
        switchMenu(SCANNER, tasks);
    }

    private static void filterTasks(Scanner SCANNER, List<Task> tasks) {
        out.println("Choose condition: " +
                "for \"category\" enter 1, for \"priority\" enter 2");
        int answerFilterCondition = receiveMenuChoice(SCANNER);

        // logics of executing of this method:
        // this method uses methods "parse" for fields Priority and Category
        // if input is correct, parsing is successful, lambda expression is filtering tasks
        // according to customers choice.
        // if input is incorrect, exception is thrown, because "parse" methods throw it
        // and filtering is performed according to default choice

        switch (answerFilterCondition) {
            case 1: {
                out.println("Choose category: \n\r0 means \"Work\", \n\r1 means \"Study\", \n\r2 means \"Family\", \n\r3 means \"Household\", \n\r4 means \"Shopping\", \n\r5 means \"Sports\", \n\r6 means \"Personal\", \n\r7 means \"Other\":\n\r");
                int filterConditionNum = receiveMenuChoice(SCANNER);
                var currCategory = Category.OTHER; // introducing default category
                try {
                    currCategory = Category.parse(filterConditionNum);
                } catch (IncorrectInputException e) {
                    e.getMessage();
                }
                Category finalCurrCat = currCategory;
                out.println(
                        tasks.stream().
                                filter(task -> task.getCategory() == finalCurrCat).
                                map(Task::toString).
                                collect(Collectors.joining("\n______________________________________\n",
                                        "Your tasks:\n", "\n"))
                );
                break;
            }
            case 2: {
                out.println("Choose priority: \n\r0 means \"High priority\", \n\r1 means \"Regular\", \n\r2 means \"Low priority\"");
                int filterConditionNum = receiveMenuChoice(SCANNER);
                var currPriority = Priority.REGULAR; // introducing default priority
                try {
                    currPriority = Priority.parse(filterConditionNum);
                } catch (IncorrectInputException e) {
                    e.getMessage();
                }
                Priority finalCurrPriority = currPriority;
                out.println(
                        tasks.stream().
                                filter(task -> task.getPriority() == finalCurrPriority).
                                map(Task::toString).
                                collect(Collectors.joining("\n______________________________________\n",
                                        "Your tasks:\n", "\n"))
                );
                break;
            }
            default:
                out.println("There is no such criteria to choose");
        }
        switchMenu(SCANNER, tasks);
    }

    private static void showDaysToDeadline(Scanner SCANNER, List<Task> tasks) {
        LocalDate todayDate = LocalDate.now();
        out.println("Remained to deadline: ");
        for (Task task : tasks) {
            Period daysToDeadline;
            if (task instanceof OneTimeTask) {
                daysToDeadline = Period.between
                        (todayDate, ((OneTimeTask) task).getToDoDate());
            } else {
                daysToDeadline = Period.between
                        (todayDate, ((RepeatableTask) task).getNextDateToDo());
            }
            out.println(">>> " + task.getTaskName()
                    + ": " + daysToDeadline.getDays() + " days");
        }
        switchMenu(SCANNER, tasks);
    }

}


