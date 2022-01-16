package by.kuzmich.taskwizard.model;

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
        System.out.println("This task is done.");

    }

    public void setToDoDate(String toDoDate) {
        this.toDoDate = toDoDate;
    }

    public String getToDoDate() {
        return toDoDate;
    }

    @Override
    public String toString() {
        return "One time task:" + "\r\n" + super.toString() +
                "To do: " + toDoDate;
    }


}
