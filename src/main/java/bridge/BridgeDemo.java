package bridge;

import bridge.vehicle_elements.Bike;
import bridge.vehicle_elements.Car;
import bridge.vehicle_elements.Truck;
import bridge.vehicle_elements.Vehicle;
import bridge.workshop_elements.Assemble;
import bridge.workshop_elements.PaintJob;
import bridge.workshop_elements.Produce;

public class BridgeDemo {

    public static void main(String[] args) {
        // Original 2-workshop combinations
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();

        Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();

        // new vehicle Truck
        Vehicle vehicle3 = new Truck(new Produce(), new Assemble());
        vehicle3.manufacture();

        // only produce and paint a truck 
        Vehicle truck2 = new Truck(new Produce(), new PaintJob());
        truck2.manufacture();

        // create a new painted car with all 3 workshops
        Vehicle paintedCar = new Car(new Produce(), new Assemble(), new PaintJob());
        paintedCar.manufacture();

    }
}
