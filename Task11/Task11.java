import java.util.ArrayList;

abstract class Vehicle {
    private String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    abstract double getRate();

    public double calculateFee(int minutes) {
        if (minutes < 0) {
            return -1;
        }

        int hours = (minutes + 59) / 60;
        return hours * getRate();
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo);
    }

    double getRate() {
        return 10;
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    double getRate() {
        return 30;
    }
}

class ElectricCar extends Vehicle {
    ElectricCar(String regNo) {
        super(regNo);
    }

    double getRate() {
        return 30;
    }
}

class ParkingTicket {
    Vehicle vehicle;
    int slotNumber;

    ParkingTicket(Vehicle vehicle, int slotNumber) {
        this.vehicle = vehicle;
        this.slotNumber = slotNumber;
    }
}

class ParkingFacility {
    private ParkingTicket[] tickets;
    private ArrayList<String> registrations;
    private int totalCollection;

    ParkingFacility(int capacity) {
        tickets = new ParkingTicket[capacity];
        registrations = new ArrayList<>();
        totalCollection = 0;
    }

    public boolean park(Vehicle vehicle) {
        if (vehicle == null) {
            System.out.println("Unknown vehicle type!");
            return false;
        }

        if (registrations.contains(vehicle.getRegNo())) {
            System.out.println("Duplicate registration rejected!");
            return false;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                tickets[i] = new ParkingTicket(vehicle, i + 1);
                registrations.add(vehicle.getRegNo());

                System.out.println(vehicle.getRegNo()
                        + " parked in Slot " + (i + 1));
                return true;
            }
        }

        System.out.println("Parking Full!");
        return false;
    }

    public void exit(String regNo, int minutes) {
        if (minutes < 0) {
            System.out.println("Invalid parking duration!");
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null &&
                tickets[i].vehicle.getRegNo().equals(regNo)) {

                double fee = tickets[i].vehicle.calculateFee(minutes);

                totalCollection += (int) fee;

                System.out.println(regNo + " exited from Slot "
                        + tickets[i].slotNumber
                        + " | Fee: Rs " + fee);

                tickets[i] = null;
                registrations.remove(regNo);
                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

    public boolean isValidSlot(int slot) {
        return slot >= 1 && slot <= tickets.length;
    }

    public int getTotalCollection() {
        return totalCollection;
    }
}

public class Task11 {
    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        ParkingFacility parking = new ParkingFacility(3);

        System.out.println("\n1. NORMAL OPERATION");
        parking.park(new TwoWheeler("TN01A1111"));
        parking.park(new Car("TN02B2222"));
        parking.park(new ElectricCar("TN03C3333"));

        System.out.println("\n2. LAST FREE SLOT TEST");
        parking.park(new Car("TN04D4444"));

        System.out.println("\n3. ZERO MINUTE PARKING");
        parking.exit("TN01A1111", 0);

        System.out.println("\n4. FEE BOUNDARY TEST");
        parking.exit("TN02B2222", 60);

        System.out.println("\n5. INVALID VEHICLE TEST");
        parking.park(null);

        System.out.println("\n6. DUPLICATE REGISTRATION TEST");
        parking.park(new Car("TN03C3333"));

        System.out.println("\n7. INVALID SLOT TEST");
        System.out.println("Slot 5 Valid: "
                + parking.isValidSlot(5));

        System.out.println("\n8. DAILY COLLECTION");
        parking.exit("TN03C3333", 120);

        System.out.println("Total Collection: Rs "
                + parking.getTotalCollection());

        System.out.println("\nTESTING COMPLETED");
    }
}
