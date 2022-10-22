package Model;

import java.util.List;

public class Doctor extends Person {
    List<Surgery> surgeries;

    public Doctor(String firstName, String lastName, List<Surgery> surgeries) {
        super(firstName, lastName);
        this.surgeries = surgeries;
    }

    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgery> surgeries) {
        this.surgeries = surgeries;
    }
}
