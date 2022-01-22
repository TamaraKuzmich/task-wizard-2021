package by.kuzmich.taskwizard.model;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Task> {

    @Override
    public int compare(Task task, Task t1) {
        return task.getCategory().compareTo(t1.getCategory());
    }
}
