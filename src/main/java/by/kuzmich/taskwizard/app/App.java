package by.kuzmich.taskwizard.app;

import by.kuzmich.taskwizard.model.*;
import by.kuzmich.taskwizard.util.OneTimeTaskCreator;
import by.kuzmich.taskwizard.util.RepeatableTaskCreator;

import static java.lang.System.*;

public class App {
    public static void main(String[] args) {

        User user = User.Builder.builder()
                .withIdentification("tamara")
                .withPassword(37)
                .withBirthDate("01.01.1984")
                .withEmail("anamara@tut.by")
                .withFirstName("Tamara")
                .build();

        User user1= User.Builder.builder()
                .withIdentification(4567)
                .withPassword(36)
                .withBirthDate("01.01.1985")
                .withEmail("student1985@tut.by")
                .withFirstName("John")
                .build();


        out.println(user);
        out.println();

        out.println(user1);
        out.println();

        OneTimeTask oneTimeTask = OneTimeTaskCreator.create();
        RepeatableTask repeatableTask = RepeatableTaskCreator.create();



        out.println();
        out.println(oneTimeTask);
        out.println();
        out.println(repeatableTask);



    }
}
