package by.kuzmich.taskwizard.model;

public abstract class Task implements Performable {
    protected String taskName;
    protected Priority priority;
    protected Category category;


    protected Task(String taskName, Priority priority, Category category) {
        this.taskName = taskName;
        this.priority = priority;
        this.category = category;
    }

    // trying to simplify defining of enums when creating new task objects
    // it could probably be useful with parse method
    // this.priority = priority.parse(0);
    // this.category = category.parse(0);


    @Override
    public String toString() {
        return "Task name: " + taskName + "\r\n" +
                "Priority: " + priority.getPriorityName() + "\r\n" +
                "Category: " + category.getCategoryName() + "\r\n";
    }

}

