package by.kuzmich.taskwizard.model;

public class NumberID extends ID <Integer> {

    public NumberID(Integer identification) {
        super(identification);
    }

    @Override
    public Integer getIdentification() {
        return identification;
    }

}