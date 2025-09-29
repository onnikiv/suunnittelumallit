package bridge.vehicle_elements;

import bridge.workshop_elements.Workshop;

public abstract class Vehicle {

    protected final Workshop workShop1;
    protected final Workshop workShop2;
    protected final Workshop workShop3; // Third Workshop

    public Vehicle(Workshop workShop1, Workshop workShop2) {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
        this.workShop3 = null; // if no third workshop then pass as null
    }

    // Added a new Constructor
    public Vehicle(Workshop workShop1, Workshop workShop2, Workshop workShop3) {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
        this.workShop3 = workShop3;
    }

    abstract public void manufacture();
}
