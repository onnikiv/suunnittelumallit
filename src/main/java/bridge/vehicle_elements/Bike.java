package bridge.vehicle_elements;

import bridge.workshop_elements.Workshop;

public class Bike extends Vehicle {

    public Bike(Workshop workShop1, Workshop workShop2) {
        super(workShop1, workShop2);
    }

    // New Constructor implemented to take in 3 workshops
    public Bike(Workshop workShop1, Workshop workShop2, Workshop workShop3) {
        super(workShop1, workShop2, workShop3);
    }

    @Override
    public void manufacture() {
        System.out.print("Bike ");
        workShop1.work();
        workShop2.work();
        if (workShop3 != null) {
            workShop3.work();
        }
        System.out.println();
    }
}
