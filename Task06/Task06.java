
class Vehicle {
    protected String vehicleNumber;
    protected String vehicleType;

    Vehicle(String vehicleNumber, String vehicleType) {
        System.out.println("1. Vehicle Constructor Called");
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

class Car extends Vehicle {

    Car(String vehicleNumber) {
        super(vehicleNumber, "Car");
        System.out.println("2. Car Constructor Called");
    }
}

class TwoWheeler extends Vehicle {

    TwoWheeler(String vehicleNumber) {
        super(vehicleNumber, "Two Wheeler");
        System.out.println("TwoWheeler Constructor Called");
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;

    ElectricCar(String vehicleNumber, int batteryCapacity) {
        super(vehicleNumber);
        System.out.println("3. ElectricCar Constructor Called");
        this.batteryCapacity = batteryCapacity;
    }

    void displayElectricDetails() {
        displayDetails();
        System.out.println("Battery Capacity: "
                + batteryCapacity + " kWh");
    }
}

public class Task06 {
    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        System.out.println("\nCreating Electric Car:");

        ElectricCar ev =
                new ElectricCar("TN01EV1234", 75);

        System.out.println("\nElectric Car Details:");
        ev.displayElectricDetails();

        System.out.println("\nCreating Two Wheeler:");

        TwoWheeler bike =
                new TwoWheeler("TN02AB5678");

        System.out.println("\nTwo Wheeler Details:");
        bike.displayDetails();
    }
}
