package by.kuzmich.taskwizard.model;

import by.kuzmich.taskwizard.app.App;
import by.kuzmich.taskwizard.util.TaskCreator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.System.*;

public class OneTimeTask extends Task {

    private LocalDate toDoDate;

    public OneTimeTask(){
    }

    public OneTimeTask(String taskName,
                       Priority priority,
                       Category category,
                       LocalDate toDoDate) {
        super(taskName, priority, category);
        this.toDoDate = toDoDate;
    }

    public void setToDoDate(LocalDate toDoDate) {
        this.toDoDate = toDoDate;
    }

    public LocalDate getToDoDate() {
        return toDoDate;
    }

    @Override
    public void markAsPerformed() {
        out.println("This task is done.");

    }

    @Override
    public String toString() {
        return super.toString() +
                "To do before: " + toDoDate.format(DateTimeFormatter
                .ofPattern(TaskCreator.DATE_PATTERN));

    }


}
