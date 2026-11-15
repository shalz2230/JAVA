
import java.util.Objects;

class Vehicle {
    private final String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public final String getRegistrationNumber() {
        return registrationNumber;
    }

    public double calculateFee(int hours) {
        return hours * 30.0;
    }

    @Override
    public String toString() {
        return "Vehicle Number: " + registrationNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Vehicle)) return false;

        Vehicle other = (Vehicle) obj;
        return registrationNumber.equals(other.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}

class Car extends Vehicle {
    Car(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int hours) {
        return hours * 50.0;
    }

    @Override
    public String toString() {
        return "Car - " + getRegistrationNumber();
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int hours) {
        return hours * 20.0;
    }

    @Override
    public String toString() {
        return "Two Wheeler - " + getRegistrationNumber();
    }
}

public class Task07 {
    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        Vehicle car = new Car("TN01AB1234");
        Vehicle bike = new TwoWheeler("TN02CD5678");

        System.out.println("\nVehicle Details:");
        System.out.println(car);
        System.out.println(bike);

        System.out.println("\nParking Fee for 3 Hours:");
        System.out.println("Car Fee: Rs " + car.calculateFee(3));
        System.out.println("Bike Fee: Rs " + bike.calculateFee(3));

        Vehicle car2 = new Car("TN01AB1234");

        System.out.println("\nEquality Checking:");
        System.out.println("Same Registration: " + car.equals(car2));
        System.out.println("Same Hash Code: "
                + (car.hashCode() == car2.hashCode()));

        System.out.println("\nDefault Vehicle Fee:");
        Vehicle other = new Vehicle("TN03EF9012");
        System.out.println("Fee: Rs " + other.calculateFee(3));
    }
}
