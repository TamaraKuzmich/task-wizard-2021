package by.kuzmich.taskwizard.model;

public enum Category {

    WORK("Work", 0),
    STUDY("Study", 1),
    FAMILY("Family", 2),
    HOUSEHOLD("Household", 3),
    SHOPPING("Shopping", 4),
    SPORTS("Sports", 5),
    PERSONAL("Personal", 6),
    OTHER("Other", 7);

    private String categoryName;
    private int categoryID;

    Category(String categoryName, int categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public Category parse(int categoryNumber) {
        for (Category category : values()) {
            if (categoryNumber == category.categoryID) {
                return category;
            }
        }
        return Category.OTHER;
    }



}





