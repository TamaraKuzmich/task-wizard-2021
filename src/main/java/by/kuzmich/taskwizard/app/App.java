package by.kuzmich.taskwizard.app;

import by.kuzmich.taskwizard.model.*;

import static java.lang.System.*;

public class App {
    public static void main(String[] args) {

        User user = User.Builder.builder()
                .withIdentification("No name")
                .withAge(37)
                .withBirthDate("01.01.1984")
                .withEmail("anamara@tut.by")
                .withFirstName("Tamara")
                .build();

        out.println(user);
        out.println();

        OneTimeTask oneTimeTask1 = new OneTimeTask("buy present for Dad",
                Priority.HIGH_PRIORITY, Category.SHOPPING,
                "2022-02-22");

        out.println(oneTimeTask1);
        out.println();

        RepeatableTask repeatableTask1 = new RepeatableTask("swipe the floor",
                Priority.LOW_PRIORITY,
                Category.HOUSEHOLD, "2022-01-05", "3 days",
                "2022-01-08");

        out.println(repeatableTask1);

    }
}
