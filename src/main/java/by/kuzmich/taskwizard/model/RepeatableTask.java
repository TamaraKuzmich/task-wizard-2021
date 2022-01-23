package by.kuzmich.taskwizard.model;

import static java.lang.System.*;

public class RepeatableTask extends Task {
    private String repeatPeriod;
    private String nextDateToDo;

    public RepeatableTask(String taskName,
                          Priority priority,
                          Category category,
                          String nextDateToDo,
                          String repeatPeriod) {
        super(taskName, priority, category);
        this.nextDateToDo = nextDateToDo;
        this.repeatPeriod = repeatPeriod;

    }

    public RepeatableTask() {

    }

    @Override
    public void markAsPerformed() {
        out.println("This task is done for today.");
    }

    public void setNextDateToDo(String nextDateToDo) {
        this.nextDateToDo = nextDateToDo;
    }

    public String getNextDateToDo() {
        return nextDateToDo;
    }

    public void setRepeatPeriod(String repeatPeriod) {
        this.repeatPeriod = repeatPeriod;
    }

    public String getRepeatPeriod() {
        return repeatPeriod;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Next day to do: " + nextDateToDo;
    }


}

