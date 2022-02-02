package by.kuzmich.taskwizard.model;

import by.kuzmich.taskwizard.util.TaskCreator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static java.lang.System.*;

public class RepeatableTask extends Task implements Serializable {

    private LocalDate nextDateToDo;
    private Period repeatPeriod;

    public RepeatableTask() {
    }

    public RepeatableTask(String taskName,
                          Priority priority,
                          Category category,
                          LocalDate nextDateToDo,
                          Period repeatPeriod) {
        super(taskName, priority, category);
        this.nextDateToDo = nextDateToDo;
        this.repeatPeriod = repeatPeriod;
    }

    public void setNextDateToDo(LocalDate nextDateToDo) {
        this.nextDateToDo = nextDateToDo;
    }

    public LocalDate getNextDateToDo() {
        return nextDateToDo;
    }

    public void setRepeatPeriod(Period repeatPeriod) {
        this.repeatPeriod = repeatPeriod;
    }

    public Period getRepeatPeriod() {
        return repeatPeriod;
    }

    @Override
    public void markAsPerformed() {
        out.println("This task is done for today.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Next day to do: " + nextDateToDo
                .format(DateTimeFormatter.ofPattern(TaskCreator.DATE_PATTERN));
    }


}

