package by.kuzmich.taskwizard.model;

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
        super(taskName, category, priority);
        this.firstDateToDo = firstDateToDo;
        this.repeatPeriod = repeatPeriod;
        this.nextDateToDo = nextDateToDo;
    }

    @Override
    public void performed() {
        System.out.println("This task is done for today.");
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

    public String getNextDateToDo() {
        return nextDateToDo;
    }

    public void setNextDateToDo(String nextDateToDo) {
        this.nextDateToDo = nextDateToDo;
    }

    @Override
    public String toString() {
        return "Repeatable task" + "\r\n" + super.toString() +
                "Next day to do: " + nextDateToDo;
    }


}

