package by.kuzmich.taskwizard.model;

public abstract class Task implements Performable {
    protected String taskName;
    protected Category category;
    protected Priority priority;

    protected Task(String taskName, Category category, Priority priority) {
        this.taskName = taskName;
        this.category = category;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task name: " + taskName + "\r\n" +
                "Category: " + category + "\r\n" +
                "Priority: " + priority + "\r\n";
    }

}

