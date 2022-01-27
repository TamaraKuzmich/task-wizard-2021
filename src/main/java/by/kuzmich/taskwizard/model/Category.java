package by.kuzmich.taskwizard.model;

import by.kuzmich.taskwizard.exception.IncorrectInputException;

public enum Category {

    WORK("Work", 0),
    STUDY("Study", 1),
    FAMILY("Family", 2),
    HOUSEHOLD("Household", 3),
    SHOPPING("Shopping", 4),
    SPORTS("Sports", 5),
    PERSONAL("Personal", 6),
    OTHER("Other", 7);

    private final String categoryName;

    private final int categoryID;

    Category(String categoryName, int categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public static Category parse(int categoryNumber) throws  IncorrectInputException {
        for (Category category : values()) {
            if (categoryNumber == category.categoryID) {
                return category;
            }
        }
        throw new IncorrectInputException();
    }

}





