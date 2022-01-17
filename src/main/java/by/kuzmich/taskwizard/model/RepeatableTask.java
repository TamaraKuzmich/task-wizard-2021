package by.kuzmich.taskwizard.model;

import static java.lang.System.*;

public class RepeatableTask extends Task {
    private String firstDateToDo;
    private String repeatPeriod;
    private String nextDateToDo;

    public RepeatableTask(String taskName,
                          Priority priority,
                          Category category,
                          String firstDateToDo,
                          String repeatPeriod,
                          String nextDateToDo) {
        super(taskName, priority, category);
        this.firstDateToDo = firstDateToDo;
        this.repeatPeriod = repeatPeriod;
        this.nextDateToDo = nextDateToDo;
    }

    public RepeatableTask() {

    }

    @Override
    public void markAsPerformed() {
        out.println("This task is done for today.");
    }

    public void setFirstDateToDo(String firstDateToDo) {
        this.firstDateToDo = firstDateToDo;
    }

    public String getFirstDateToDo() {
        return firstDateToDo;
    }

    public void setRepeatPeriod(String repeatPeriod) {
        this.repeatPeriod = repeatPeriod;
    }

    public String getRepeatPeriod() {
        return repeatPeriod;
    }

    public void setNextDateToDo(String nextDateToDo) {
        this.nextDateToDo = nextDateToDo;
    }

    public String getNextDateToDo() {
        return nextDateToDo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Next day to do: " + nextDateToDo;
    }


}

