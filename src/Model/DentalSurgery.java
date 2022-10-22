package Model;

import java.util.List;

public class DentalSurgery extends Surgery {
    Integer teethCount;

    public DentalSurgery(List<Doctor> doctors, Patient patient, Integer teethCount) {
        super(doctors, patient);
        this.teethCount = teethCount;
    }

    @Override
    public Integer calculatePrice() {
        return teethCount * 100;
    }
}
