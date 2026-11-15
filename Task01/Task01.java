

class Vehicle {
    String regNo;
    String vehicleType;

    Vehicle(String regNo, String vehicleType) {
        this.regNo = regNo;
        this.vehicleType = vehicleType;
    }

    void displayVehicle() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

class User {
    String name;
    String userType;

    User(String name, String userType) {
        this.name = name;
        this.userType = userType;
    }

    void displayUser() {
        System.out.println("User Name: " + name);
        System.out.println("User Type: " + userType);
    }
}

class ParkingSlot {
    int floorNo;
    int slotNo;
    boolean occupied;

    ParkingSlot(int floorNo, int slotNo) {
        this.floorNo = floorNo;
        this.slotNo = slotNo;
        this.occupied = false;
    }

    boolean allocateSlot() {
        if (!occupied) {
            occupied = true;
            return true;
        }
        return false;
    }
}

class ParkingTicket {
    int ticketNo;
    Vehicle vehicle;

    ParkingTicket(int ticketNo, Vehicle vehicle) {
        this.ticketNo = ticketNo;
        this.vehicle = vehicle;
    }

    void displayTicket() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Vehicle: " + vehicle.regNo);
    }
}

class ParkingFacility {
    ParkingSlot slot;

    ParkingFacility(ParkingSlot slot) {
        this.slot = slot;
    }

    void parkVehicle(Vehicle vehicle) {
        if (slot.allocateSlot()) {
            System.out.println("Vehicle Parked Successfully!");
            System.out.println("Floor Number: " + slot.floorNo);
            System.out.println("Slot Number: " + slot.slotNo);
        } else {
            System.out.println("Parking Slot is Already Occupied!");
        }
    }
}

public class Task01 {
    public static void main(String[] args) {

        User user = new User("Krishna", "Student");

        Vehicle vehicle = new Vehicle("TN01AB1234", "Car");

        ParkingSlot slot = new ParkingSlot(1, 101);

        ParkingFacility facility = new ParkingFacility(slot);

        ParkingTicket ticket = new ParkingTicket(1001, vehicle);

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("---------------------------");

        user.displayUser();

        System.out.println();

        vehicle.displayVehicle();

        System.out.println();

        facility.parkVehicle(vehicle);

        System.out.println();

        ticket.displayTicket();

        System.out.println();

        facility.parkVehicle(vehicle);
    }
}
