abstract class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours);
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    double calculateFee(int hours) {
        return hours * 30;
    }
}

class EBike extends Vehicle {
    EBike(String regNo) {
        super(regNo);
    }

    double calculateFee(int hours) {
        return 20; // Flat fee
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) {
        super(regNo);
    }

    double calculateFee(int hours) {
        return hours * 60; // Double car rate
    }
}

class VisitorPass extends Vehicle {
    VisitorPass(String regNo) {
        super(regNo);
    }

    double calculateFee(int hours) {
        return 100; // One-day pass
    }
}

class ParkingFloor {
    int floorNumber;
    int totalSlots;

    ParkingFloor(int floorNumber, int totalSlots) {
        this.floorNumber = floorNumber;
        this.totalSlots = totalSlots;
    }

    void display() {
        System.out.println("Floor " + floorNumber
                + " - Slots: " + totalSlots);
    }
}

public class Task12 {
    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        ParkingFloor[] floors = {
            new ParkingFloor(1, 10),
            new ParkingFloor(2, 15),
            new ParkingFloor(3, 20),
            new ParkingFloor(4, 12),
            new ParkingFloor(5, 18)
        };

        System.out.println("\nPARKING FLOOR DETAILS");

        int total = 0;

        for (ParkingFloor floor : floors) {
            floor.display();
            total += floor.totalSlots;
        }

        System.out.println("Total Parking Slots: " + total);

        System.out.println("\nVEHICLE FEE DETAILS");

        Vehicle[] vehicles = {
            new Car("TN01A1111"),
            new EBike("TN02B2222"),
            new DeliveryVan("TN03C3333"),
            new VisitorPass("TN04D4444")
        };

        int hours = 3;

        for (Vehicle v : vehicles) {
            System.out.println(v.getClass().getSimpleName()
                    + " (" + v.regNo + ") Fee: Rs "
                    + v.calculateFee(hours));
        }

        System.out.println("\nDESIGN EVALUATION");
        System.out.println("Existing system is modified.");
        System.out.println("New vehicle types are supported.");
        System.out.println("Different floors have different slot counts.");
        System.out.println("Visitor one-day pass is available.");
        System.out.println("Delivery vans use double car rate.");

        System.out.println("\nTESTING COMPLETED");
    }
}
