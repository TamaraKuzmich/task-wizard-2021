package by.kuzmich.taskwizard.util;

import by.kuzmich.taskwizard.exception.IncorrectInputException;
import by.kuzmich.taskwizard.model.*;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.lang.System.*;

@UtilityClass
public class TaskCreator {

    private final Scanner SCANNER = new Scanner(in);

    // DATE_PATTERN is used not only in Task Creator class,
    // but in Task inheritors, which seems to be strange
    // toDo: place DATE_PATTERN on the most common and logical place to improve hierarchy of project
    public final String DATE_PATTERN = "dd.MM.yyyy";
    public final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    // there are 3 attempts to enter correct number.
    // IncorrectInputException is thrown if input is a number,
    // but there is no such number in menu
    // NumberFormatException is thrown if input is not an int number.
    public Task create(String newTaskName) {
        out.println("Enter 1 if you expect to perform this task once. \r\n" +
                "Enter 2 if it is a regular task");
        for (int i = 1; true; i++) {
            try {
                int choice = Integer.parseInt(SCANNER.nextLine());
                switch (choice) {
                    case (1): {
                        return createOneTimeTask(newTaskName);
                    }
                    case (2): {
                        return createRepeatableTask(newTaskName);
                    }
                    default:
                        throw new IncorrectInputException();
                }
            } catch (NumberFormatException | IncorrectInputException e) {
                out.println(e.getMessage());
                if (i >= 3) {
                    break;
                }
                out.println("Try enter again.");
            }
        }
        out.println("Let's try to write down a task to perform once.");
        return createOneTimeTask(newTaskName);
    }

    public OneTimeTask createOneTimeTask(String newTaskName) {
        OneTimeTask oneTimeTask = new OneTimeTask();
        oneTimeTask.setTaskName(newTaskName);
        oneTimeTask.setPriority(getPriorityFromUser());
        oneTimeTask.setCategory(getCategoryFromUser());
        oneTimeTask.setToDoDate(getToDoDateFromUser());
        return oneTimeTask;
    }

    public RepeatableTask createRepeatableTask(String newTaskName) {
        RepeatableTask repeatableTask = new RepeatableTask();
        repeatableTask.setTaskName(newTaskName);
        repeatableTask.setPriority(getPriorityFromUser());
        repeatableTask.setCategory(getCategoryFromUser());
        repeatableTask.setNextDateToDo(getNextDateToDoFromUser());
        repeatableTask.setRepeatPeriod(getRepeatPeriodFromUser());
        return repeatableTask;
    }

    private Priority getPriorityFromUser() {
        out.print("Define priority level: \n\r" +
                "(0 means \"High priority\", 1 means \"Regular\", 2 means \"Low priority\") : ");
        try {
            return Priority.parse(receiveAnswerNumberFromUser());
        } catch (NumberFormatException | IncorrectInputException e) {
            e.getMessage();
        }
        out.println("There is no such priority level in the list. \r\n" +
                "If you don't mind, I'll match it as \"Regular\"");
        return Priority.REGULAR;

    }

    private Category getCategoryFromUser() {
        out.print("Choose category: \n\r" +
                "0 means \"Work\", \n\r1 means \"Study\", \n\r2 means \"Family\", " +
                "\n\r3 means \"Household\", \n\r4 means \"Shopping\", \n\r5 means \"Sports\", " +
                "\n\r6 means \"Personal\", \n\r7 means \"Other\":\n\r");
        try {
            return Category.parse(receiveAnswerNumberFromUser());
        } catch (NumberFormatException | IncorrectInputException e) {
            e.getMessage();
        }
        out.println("There is no such category in the list. \r\n" +
                "If you don't mind, I'll match category as \"Other\"");
        return Category.OTHER;
    }

    private LocalDate getNextDateToDoFromUser() {
        out.printf("Enter date to do (%s): ", DATE_PATTERN);
        return LocalDate.parse(SCANNER.nextLine(), DATE_FORMATTER);
    }

    private Period getRepeatPeriodFromUser() {
        out.print("Enter frequency of performing: ");
        return Period.parse(SCANNER.nextLine());
    }

    private LocalDate getToDoDateFromUser() {
        out.printf("Enter date to do (%s): ", DATE_PATTERN);
        return LocalDate.parse(SCANNER.nextLine(), DATE_FORMATTER);
    }

    public static int receiveAnswerNumberFromUser() throws NumberFormatException {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("You didn't enter number.");
        }
    }

}