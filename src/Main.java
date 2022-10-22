import Controller.Controller;
import Model.*;
import View.View;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Patient> initialPatients = new ArrayList<Patient>();
        initialPatients.add(new Patient("Alin", "Ciobanu", 300, new ArrayList<Surgery>()));
        initialPatients.add(new Patient("Emanuel", "Ciubuca", 10000, new ArrayList<Surgery>()));
        List<Doctor> initialDoctors = new ArrayList<Doctor>();
        initialDoctors.add(new Doctor("Adi", "Spatar", new ArrayList<Surgery>()));
        initialDoctors.add(new Doctor("Dragos", "Apostol", new ArrayList<Surgery>()));
        List<Surgery> initialSurgeries = new ArrayList<Surgery>();
        {
            List<Doctor> doctors = new ArrayList<Doctor>();
            doctors.add(initialDoctors.get(0));
            initialSurgeries.add(new DentalSurgery(doctors, initialPatients.get(0), 4));
        }
        {
            List<Doctor> doctors = new ArrayList<Doctor>();
            doctors.add(initialDoctors.get(1));
            initialSurgeries.add(new BodySurgery(doctors, initialPatients.get(1), true, true, false, true));
        }
        List<Person> initialPersons = new ArrayList<Person>();
        initialPersons.addAll(initialPatients);
        initialPersons.addAll(initialDoctors);
        Controller controller = new Controller(initialSurgeries, initialPersons);
        View view = new View(controller);
        view.run();
    }
}