package by.kuzmich.taskwizard.app;

import by.kuzmich.taskwizard.model.OneTimeTask;
import by.kuzmich.taskwizard.model.RepeatableTask;

public class App {
    public static void main(String[] args) {

        OneTimeTask oneTimeTask1 = new OneTimeTask("do homework 4",
                "studying", "high", "12-21-2021");
        System.out.println(oneTimeTask1);

        RepeatableTask repeatableTask1 = new RepeatableTask("do the laundry",
                "household", "medium", "12-22-2021",
                "every week");
        System.out.println(repeatableTask1);
    }
}
