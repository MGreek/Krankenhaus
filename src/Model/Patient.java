package Model;

import java.util.List;

public class Patient extends Person implements Comparable<Patient> {
    Integer balance;
    List<Surgery> surgeries;

    public Patient(String firstName, String lastName, Integer balance, List<Surgery> surgeries) {
        super(firstName, lastName);
        this.balance = balance;
        this.surgeries = surgeries;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    @Override
    public int compareTo(Patient o) {
        return balance - o.balance;
    }
}
