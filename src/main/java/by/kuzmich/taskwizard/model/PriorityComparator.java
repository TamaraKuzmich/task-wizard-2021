package by.kuzmich.taskwizard.model;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Task> {

    @Override
    public int compare(Task task, Task t1) {
        return task.getPriority().compareTo(t1.getPriority());
    }
}

