package by.kuzmich.taskwizard.model;

public class OneTimeTask extends Task {

    private String toDoDate;

    public OneTimeTask(String taskName,
                       String category,
                       String priority,
                       String toDoDate) {
        this.taskName = taskName;
        this.category = category;
        this.priority = priority;
        this.toDoDate = toDoDate;
    }

    @Override
    public void performed() {
        System.out.println("This task is done.");

    }

    public void setToDoDate(String toDoDate) {
        this.toDoDate = toDoDate;
    }

    public String getToDoDate() {
        return toDoDate;
    }

    public String toString() {
        return "New task: " + taskName + "\r\n" +
                "Category: " + category + "\r\n" +
                "Priority: " + priority + "\r\n" +
                "To do: " + toDoDate;
    }

}
