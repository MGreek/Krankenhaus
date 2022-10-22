package View;

import Controller.Controller;
import Model.Doctor;
import Model.Patient;
import Model.Surgery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class View {
    Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    void printAllPatients()
    {
        List<Patient> patients = controller.getPatients();
        for (Patient patient : patients)
            printPatient(patient);
    }

    private static void printPatient(Patient patient) {
        System.out.print(patient.getFirstName());
        System.out.print(' ');
        System.out.print(patient.getLastName());
        System.out.print(' ');
        System.out.println(patient.getBalance());
    }

    void printAllDoctors()
    {
        printDoctors(controller.getDoctors());
    }

    private static void printDoctors(List<Doctor> doctors) {
        for (Doctor doctor : doctors)
        {
            System.out.print(doctor.getFirstName());
            System.out.print(' ');
            System.out.println(doctor.getLastName());
        }
    }

    void printAllSurgeries()
    {
        List<Surgery> surgeries = controller.getSurgeries();
        printSurgeries(surgeries);
    }

    private static void printSurgeries(List<Surgery> surgeries) {
        for (Surgery surgery : surgeries)
        {
            System.out.println("Patient:");
            printPatient(surgery.getPatient());
            System.out.println("Doctors:");
            printDoctors(surgery.getDoctors());
            System.out.println("Price:");
            System.out.println(surgery.calculatePrice());
        }
    }

    void printPatientsByBalance()
    {
        List<Patient> patients = controller.getPatientsByBalance();
        for (Patient patient : patients)
            printPatient(patient);
    }

    void printSurgeriesByCost()
    {
        printSurgeries(controller.getSurgeriesByCost());
    }

    void addDentalSurgery()
    {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Enter patient firstname: ");
        String firstName = sc.nextLine().strip();
        System.out.print("Enter patient lastname: ");
        String lastName = sc.nextLine().strip();
        Patient targetPatient = null;
        for (Patient patient : controller.getPatients())
            if (Objects.equals(patient.getFirstName(), firstName) && Objects.equals(patient.getLastName(), lastName)) {
                targetPatient = patient;
                break;
            }
        if (targetPatient == null) {
            System.out.println("Invalid patient!");
            return;
        }
        List<Doctor> targetDoctors = new ArrayList<Doctor>();
        System.out.print("Number of doctors: ");
        Integer n;
        try {
            n = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException ignored)
        {
            System.out.println("Invalid number of doctors!");
            return;
        }
        for (int i = 0; i < n; ++i)
        {
            System.out.print("Enter doctor firstname: ");
            firstName = sc.nextLine().strip();
            System.out.print("Enter doctor lastname: ");
            lastName = sc.nextLine().strip();
            Doctor targetDoctor = null;
            for (Doctor doctor : controller.getDoctors())
                if (Objects.equals(doctor.getFirstName(), firstName) && Objects.equals(doctor.getLastName(), lastName))
                {
                    targetDoctor = doctor;
                    targetDoctors.add(targetDoctor);
                    break;
                }
            if (targetDoctor == null)
            {
                System.out.println("Invalid doctor!");
                return;
            }
        }
        System.out.print("Number of teeth: ");
        Integer teethCount;
        try {
            teethCount = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException ignored)
        {
            System.out.println("Invalid number of teeth!");
            return;
        }
        controller.addDentalSurgery(targetDoctors, targetPatient, teethCount);
    }

    void addBodySurgery()
    {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Enter patient firstname: ");
        String firstName = sc.nextLine().strip();
        System.out.print("Enter patient lastname: ");
        String lastName = sc.nextLine().strip();
        Patient targetPatient = null;
        for (Patient patient : controller.getPatients())
        {
            if (Objects.equals(patient.getFirstName(), firstName) && Objects.equals(patient.getLastName(), lastName)) {
                targetPatient = patient;
                break;
            }
        }
        if (targetPatient == null) {
            System.out.println("Invalid patient!");
            return;
        }
        List<Doctor> targetDoctors = new ArrayList<Doctor>();
        System.out.print("Number of doctors: ");
        Integer n;
        try {
            n = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException ignored)
        {
            System.out.println("Invalid number of doctors!");
            return;
        }
        for (int i = 0; i < n; ++i)
        {
            System.out.print("Enter doctor firstname: ");
            firstName = sc.nextLine().strip();
            System.out.print("Enter doctor lastname: ");
            lastName = sc.nextLine().strip();
            Doctor targetDoctor = null;
            for (Doctor doctor : controller.getDoctors()) {
                if (Objects.equals(doctor.getFirstName(), firstName) && Objects.equals(doctor.getLastName(), lastName)) {
                    targetDoctor = doctor;
                    targetDoctors.add(targetDoctor);
                    break;
                }
            }
            if (targetDoctor == null)
            {
                System.out.println("Invalid doctor!");
                return;
            }
        }
        System.out.print("Arms?: ");
        Boolean arms = Boolean.parseBoolean(sc.nextLine());
        System.out.print("Feet?: ");
        Boolean feet = Boolean.parseBoolean(sc.nextLine());
        System.out.print("Head?: ");
        Boolean head = Boolean.parseBoolean(sc.nextLine());
        System.out.print("Torso?: ");
        Boolean torso = Boolean.parseBoolean(sc.nextLine());
        controller.addBodySurgery(targetDoctors, targetPatient, arms, feet, head, torso);
    }

    private static void printMenu()
    {
        System.out.println("1) Print patients\n2) Print doctors\n3) Print surgeries\n4) Print patients (sorted by balance)\n5) Print surgeries (sorted by cost)\n6) Add surgery (dental)\n7) Add surgery (body)\n8) Exit");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("Option: ");
            Integer option;
            try {
                option = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException ignored)
            {
                System.out.println("Invalid option!");
                continue;
            }
            switch (option)
            {
                case 1:
                {
                    printAllPatients();
                    break;
                }
                case 2:
                {
                    printAllDoctors();
                    break;
                }
                case 3:
                {
                    printAllSurgeries();
                    break;
                }
                case 4:
                {
                    printPatientsByBalance();
                    break;
                }
                case 5:
                {
                    printSurgeriesByCost();
                    break;
                }
                case 6:
                {
                    addDentalSurgery();
                    break;
                }
                case 7:
                {
                    addBodySurgery();
                    break;
                }
                case 8:
                {
                    return;
                }
                default:
                {
                    System.out.println("Unknown option!\n");
                    break;
                }
            }
        }
    }
}
