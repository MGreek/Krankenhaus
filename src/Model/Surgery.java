package Model;

import java.util.List;

public abstract class Surgery implements Comparable<Surgery> {
    List<Doctor> doctors;
    Patient patient;

    public abstract Integer calculatePrice();

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Surgery(List<Doctor> doctors, Patient patient) {
        this.doctors = doctors;
        this.patient = patient;
        for (Doctor doctor : doctors)
            doctor.surgeries.add(this);
        patient.surgeries.add(this);
    }

    @Override
    public int compareTo(Surgery o) {
        return calculatePrice() - o.calculatePrice();
    }
}
