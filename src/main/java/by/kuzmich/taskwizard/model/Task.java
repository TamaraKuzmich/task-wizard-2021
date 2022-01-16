package by.kuzmich.taskwizard.model;

public abstract class Task implements Performable {

    protected String taskName;
    protected Priority priority;
    protected Category category;

    protected Task() {
    }

    protected Task(String taskName, Priority priority, Category category) {
        this.taskName = taskName;
        this.priority = priority;
        this.category = category;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Task name: " + taskName + "\r\n" +
                "Priority: " + priority.getPriorityName() + "\r\n" +
                "Category: " + category.getCategoryName() + "\r\n";
    }

}

