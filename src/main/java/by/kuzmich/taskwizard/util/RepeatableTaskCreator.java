package by.kuzmich.taskwizard.util;

import by.kuzmich.taskwizard.model.Category;
import by.kuzmich.taskwizard.model.RepeatableTask;
import by.kuzmich.taskwizard.model.Priority;
import lombok.experimental.UtilityClass;

import java.util.Scanner;

import static java.lang.System.*;

@UtilityClass
public class RepeatableTaskCreator {

    private final Scanner SCANNER = new Scanner(in);

    public RepeatableTask create() {
        RepeatableTask repeatableTask = new RepeatableTask();
        repeatableTask.setTaskName(getTaskNameFromUser());
        repeatableTask.setPriority(getPriorityFromUser());
        repeatableTask.setCategory(getCategoryFromUser());
        repeatableTask.setFirstDateToDo(getFirstDayToDoFromUser());
        repeatableTask.setRepeatPeriod(getRepeatPeriodFromUser());
        return repeatableTask;
    }

    private String getTaskNameFromUser() {
        out.print("Enter task name: ");
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

    private String getFirstDayToDoFromUser() {
        out.print("Enter first date to do: ");
        String dateFromUser = SCANNER.nextLine();
        return dateFromUser;
    }

    private String getRepeatPeriodFromUser() {
        out.print("Enter frequency of performing: ");
        String dateFromUser = SCANNER.nextLine();
        return dateFromUser;
    }


}