package by.kuzmich.taskwizard.model;

public class ID<I> {

    protected I identification;

    public ID(I identification) {
        this.identification = identification;
    }

    public void setIdentification(I identification) {
        this.identification = identification;
    }

    public I getIdentification() {
        return identification;
    }

    @Override
    public String toString() {
        return "Your UserID: " +
                getIdentification().toString();
    }
}
