package by.kuzmich.taskwizard.model;

public abstract class ID<N> {
    protected N identification;

    protected ID (N identification) {
        this.identification = identification;
    }

    public abstract N getIdentification();

    @Override
    public String toString() {
        return getIdentification().toString();
    }
}
