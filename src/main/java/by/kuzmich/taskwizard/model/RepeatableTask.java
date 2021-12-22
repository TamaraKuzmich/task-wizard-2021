package by.kuzmich.taskwizard.model;

public class RepeatableTask extends Task {
    private String firstDateToDo;
    private String repeatPeriod;

    public RepeatableTask(String taskName,
                          String category,
                          String priority,
                          String firstDateToDo,
                          String repeatPeriod) {
        this.taskName = taskName;
        this.category = category;
        this.priority = priority;
        this.firstDateToDo = firstDateToDo;
        this.repeatPeriod = repeatPeriod;
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

    public String toString() {
        return "New task: " + taskName + "\r\n" +
                "Category: " + category + "\r\n" +
                "Priority: " + priority + "\r\n";
    }


}
