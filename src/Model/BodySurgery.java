package Model;

import java.util.List;

public class BodySurgery extends Surgery {
    Boolean arms;
    Boolean feet;
    Boolean head;
    Boolean torso;

    public BodySurgery(List<Doctor> doctors, Patient patient, Boolean arms, Boolean feet, Boolean head, Boolean torso) {
        super(doctors, patient);
        this.arms = arms;
        this.feet = feet;
        this.head = head;
        this.torso = torso;
    }

    @Override
    public Integer calculatePrice() {
        Integer price = 0;
        if (arms)
            price += 20;
        if (feet)
            price += 10;
        if (head)
            price += 100;
        if (torso)
            price += 50;
        return price;
    }
}
