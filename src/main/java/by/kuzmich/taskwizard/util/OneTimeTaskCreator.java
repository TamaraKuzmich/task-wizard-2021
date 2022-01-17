package by.kuzmich.taskwizard.util;

import by.kuzmich.taskwizard.model.Category;
import by.kuzmich.taskwizard.model.OneTimeTask;
import by.kuzmich.taskwizard.model.Priority;
import lombok.experimental.UtilityClass;

import java.util.Scanner;

import static java.lang.System.*;

@UtilityClass
public class OneTimeTaskCreator {

    private final Scanner SCANNER = new Scanner(in);

    public OneTimeTask create() {
        OneTimeTask oneTimeTask = new OneTimeTask();
        oneTimeTask.setTaskName(getTaskNameFromUser());
        oneTimeTask.setPriority(getPriorityFromUser());
        oneTimeTask.setCategory(getCategoryFromUser());
        oneTimeTask.setToDoDate(getToDoDateFromUser());
        return oneTimeTask;
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

    private String getToDoDateFromUser() {
        out.print("Enter to do date of task: ");
        return SCANNER.nextLine();
    }


}
