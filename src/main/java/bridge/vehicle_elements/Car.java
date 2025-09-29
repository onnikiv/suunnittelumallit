package bridge.vehicle_elements;

import bridge.workshop_elements.Workshop;

public class Car extends Vehicle {

    public Car(Workshop workShop1, Workshop workShop2) {
        super(workShop1, workShop2);
    }

    // New Constructor implemented to take in 3 workshops
    public Car(Workshop workShop1, Workshop workShop2, Workshop workShop3) {
        super(workShop1, workShop2, workShop3);
    }

    @Override
    public void manufacture() {
        System.out.print("Car ");
        workShop1.work();
        workShop2.work();
        if (workShop3 != null) {
            workShop3.work();
        }
        System.out.println();
    }
}
