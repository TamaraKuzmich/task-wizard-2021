package by.kuzmich.taskwizard.model;

public enum Priority {
    LOW_PRIORITY("Low priority"),
    REGULAR("Regular"),
    HIGH_PRIORITY("HIGH PRIORITY");

    protected String priorityName;

    Priority(String priorityNameName) {
        this.priorityName = priorityName;
    }
}

