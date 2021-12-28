package by.kuzmich.taskwizard.model;

public enum Category {
    WORK ("Work"),
    STUDY ("Study"),
    FAMILY ("Family"),
    HOUSEHOLD ("Household"),
    SHOPPING ("Shopping"),
    SPORTS ("Sports"),
    PERSONAL ("Personal"),
    OTHER ("Other");

    protected String categoryName;

    Category (String categoryName){
        this.categoryName = categoryName;
    }
}
