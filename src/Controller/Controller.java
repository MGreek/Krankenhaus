package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    List<Surgery> surgeries;
    List<Person> persons;

    public Controller(List<Surgery> surgeries, List<Person> persons) {
        this.surgeries = surgeries;
        this.persons = persons;
        for (Surgery surgery : surgeries)
        {
            for (Doctor doctor : surgery.getDoctors())
                if (!persons.contains(doctor))
                    throw new RuntimeException("Surgeries/Persons not compatible!");
            if (!persons.contains(surgery.getPatient()))
                throw new RuntimeException("Surgeries/Persons not compatible!");
        }
    }

    public List<Patient> getPatients()
    {
        List<Patient> result = new ArrayList<Patient>();
        for (Person person : persons)
        {
            try {
                Patient patient = (Patient) person;
                result.add(patient);
            } catch (ClassCastException ignored) {
            }
        }
        return result;
    }

    public List<Doctor> getDoctors()
    {
        List<Doctor> result = new ArrayList<Doctor>();
        for (Person person : persons)
        {
            try {
                Doctor doctor = (Doctor) person;
                result.add(doctor);
            } catch (ClassCastException ignored) {
            }
        }
        return result;
    }

    public List<Surgery> getSurgeries()
    {
        return new ArrayList<>(surgeries);
    }

    public List<Patient> getPatientsByBalance()
    {
        List<Patient> patients = getPatients();
        Collections.sort(patients);
        return patients;
    }

    public List<Surgery> getSurgeriesByCost()
    {
        List<Surgery> sortedSurgeries = getSurgeries();
        Collections.sort(sortedSurgeries);
        return sortedSurgeries;
    }

    public void addDentalSurgery(List<Doctor> doctors, Patient patient, Integer teethCount)
    {
        for (Doctor doctor : doctors)
            if (!getDoctors().contains(doctor)) {
                throw new RuntimeException("Doctor list not valid!");
            }
        if (!getPatients().contains(patient))
            throw new RuntimeException("Patient not valid!");
        surgeries.add(new DentalSurgery(doctors, patient, teethCount));
    }

    public void addBodySurgery(List<Doctor> doctors, Patient patient, Boolean arms, Boolean feet, Boolean head, Boolean torso)
    {
        for (Doctor doctor : doctors)
            if (!getDoctors().contains(doctor)) {
                throw new RuntimeException("Doctor list not valid!");
            }
        if (!getPatients().contains(patient))
            throw new RuntimeException("Patient not valid!");
        surgeries.add(new BodySurgery(doctors, patient, arms, feet, head, torso));
    }
}
