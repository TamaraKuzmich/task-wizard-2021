package by.kuzmich.taskwizard.model;

import java.util.Objects;

public abstract class Task implements Performable, Comparable<Task> {

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
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        // Check if o is not null and is an instance of Task
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        // typecast o to Task so that we can compare chosen fields
        Task t = (Task) o;
        return t.taskName.equalsIgnoreCase(taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName);
    }

    @Override
    public int compareTo(Task otherTask) {
        return taskName.compareTo(otherTask.taskName);
    }

    @Override
    public String toString() {
        return "Task name: " + taskName + "\r\n" +
                "Priority: " + priority.getPriorityName() + "\r\n" +
                "Category: " + category.getCategoryName() + "\r\n";
    }

}

