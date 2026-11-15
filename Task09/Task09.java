
interface Chargeable {
    double chargingFee(int units);

    default void showChargingInfo() {
        System.out.println("EV Charging Facility Available");
    }

    static int getChargingRate() {
        return 12;
    }
}

abstract class Vehicle {
    private String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    abstract double calculateFee(int hours);

    public void display() {
        System.out.println("Registration Number: " + regNo);
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30;
    }
}

class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30;
    }

    @Override
    public double chargingFee(int units) {
        return units * Chargeable.getChargingRate();
    }
}

public class Task09 {
    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        Vehicle car = new Car("TN01AB1234");
        Vehicle ev = new ElectricCar("TN02CD5678");

        System.out.println("\nCar Details:");
        car.display();
        System.out.println("Parking Fee: Rs " + car.calculateFee(3));

        System.out.println("\nElectric Car Details:");
        ev.display();
        System.out.println("Parking Fee: Rs " + ev.calculateFee(3));

        Chargeable charging = (Chargeable) ev;
        charging.showChargingInfo();

        System.out.println("Charging Fee: Rs " + charging.chargingFee(10));
    }
}
