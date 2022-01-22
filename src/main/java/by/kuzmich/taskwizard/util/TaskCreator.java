package by.kuzmich.taskwizard.util;

import by.kuzmich.taskwizard.model.*;
import lombok.experimental.UtilityClass;

import java.util.Scanner;

import static java.lang.System.*;

@UtilityClass
public class TaskCreator {

    private final Scanner SCANNER = new Scanner(in);

    public Task create() {
        out.println("Enter 1 if you expect to perform this task once. \r\n" +
                "Enter 2 if it is a regular task");
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        if (choice == 1)
            return createOneTimeTask();
        else return createRepeatableTask();
    }

    public OneTimeTask createOneTimeTask() {
        OneTimeTask oneTimeTask = new OneTimeTask();
        oneTimeTask.setTaskName(getTaskNameFromUser());
        oneTimeTask.setPriority(getPriorityFromUser());
        oneTimeTask.setCategory(getCategoryFromUser());
        oneTimeTask.setToDoDate(getToDoDateFromUser());
        return oneTimeTask;
    }

    public RepeatableTask createRepeatableTask() {
        RepeatableTask repeatableTask = new RepeatableTask();
        repeatableTask.setTaskName(getTaskNameFromUser());
        repeatableTask.setPriority(getPriorityFromUser());
        repeatableTask.setCategory(getCategoryFromUser());
        repeatableTask.setNextDateToDo(getNextDateToDoFromUser());
        repeatableTask.setRepeatPeriod(getRepeatPeriodFromUser());
        return repeatableTask;
    }


    private String getTaskNameFromUser() {
        out.print("Enter the name of your task: ");
        return SCANNER.nextLine();
    }

    private Priority getPriorityFromUser() {
        out.print("Define priority level: \n\r" +
                "(0 means \"High priority\", 1 means \"Regular\", 2 means \"Low priority\") : ");
        return Priority.parse(SCANNER.nextInt());
    }

    private Category getCategoryFromUser() {
        out.print("Choose category: \n\r" +
                "0 means \"Work\", \n\r1 means \"Study\", \n\r2 means \"Family\", " +
                "\n\r3 means \"Household\", \n\r4 means \"Shopping\", \n\r5 means \"Sports\", " +
                "\n\r6 means \"Personal\", \n\r7 means \"Other\":\n\r");
        int categoryFromUser = SCANNER.nextInt();
        SCANNER.nextLine();
        return Category.parse(categoryFromUser);
    }

    private String getNextDateToDoFromUser() {
        out.print("Enter date to do: ");
        return SCANNER.nextLine();
    }

    private String getRepeatPeriodFromUser() {
        out.print("Enter frequency of performing: ");
        return SCANNER.nextLine();
    }

    private String getToDoDateFromUser() {
        out.print("Enter date to do: ");
        return SCANNER.nextLine();
    }


}