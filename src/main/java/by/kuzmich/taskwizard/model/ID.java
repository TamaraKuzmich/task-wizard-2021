package by.kuzmich.taskwizard.model;

public abstract class ID<I> {

    protected I identification;

    public ID(I identification) {
        this.identification = identification;
    }

    public abstract I getIdentification();

    @Override
    public String toString() {
        return "Your UserID: " + getIdentification().toString();
    }
}
