package by.kuzmich.taskwizard.model;

public class NameID extends ID<String> {

    protected NameID(String identification) {
        super(identification);
    }

    @Override
    public String getIdentification() {
        return identification;
    }
}
