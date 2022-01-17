package by.kuzmich.taskwizard.model;

import static java.lang.System.*;

public class OneTimeTask extends Task {

    private String toDoDate;

    public OneTimeTask(){
    }

    public OneTimeTask(String taskName,
                       Priority priority,
                       Category category,
                       String toDoDate) {
        super(taskName, priority, category);
        this.toDoDate = toDoDate;
    }

    @Override
    public void markAsPerformed() {
        out.println("This task is done.");

    }

    public void setToDoDate(String toDoDate) {
        this.toDoDate = toDoDate;
    }

    public String getToDoDate() {
        return toDoDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "To do before: " + toDoDate;
    }


}
