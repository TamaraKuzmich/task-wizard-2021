package by.kuzmich.taskwizard.model;

import java.sql.PreparedStatement;

public enum Priority {

    HIGH_PRIORITY("HIGH PRIORITY", 0),
    REGULAR("Regular", 1),
    LOW_PRIORITY("Low priority", 2);


    private String priorityName;
    private int priorityID;

    Priority(String priorityName, int priorityID) {
        this.priorityName = priorityName;
        this.priorityID = priorityID;
    }

    public String getPriorityName(){
        return priorityName;
    }

    public Priority parse (int priorityNumber) {
        for (Priority priority : values()) {
            if (priorityNumber == priority.priorityID) {
                return priority;
            }
        }
        return Priority.LOW_PRIORITY;
    }


}

