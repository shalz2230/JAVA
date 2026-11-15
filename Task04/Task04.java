
class ParkingTicket {

    int ticketNo;
    String vehicleNo;
    double parkingFee;

    // Default constructor
    ParkingTicket() {
        this(1001, "NOT ASSIGNED", 0.0);
    }

    // Parameterized constructor
    ParkingTicket(int ticketNo, String vehicleNo) {
        this(ticketNo, vehicleNo, 30.0);
    }

    // Overloaded constructor
    ParkingTicket(int ticketNo, String vehicleNo, double parkingFee) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
        this.parkingFee = parkingFee;
    }

    // Copy constructor
    ParkingTicket(ParkingTicket other) {
        this(other.ticketNo, other.vehicleNo, other.parkingFee);
    }

    void displayTicket() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Parking Fee: Rs " + parkingFee);
        System.out.println("----------------------");
    }
}

public class Task04 {

    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        // Default constructor
        ParkingTicket t1 = new ParkingTicket();

        // Parameterized constructor
        ParkingTicket t2 = new ParkingTicket(1002, "TN01AB1234");

        // Overloaded constructor
        ParkingTicket t3 = new ParkingTicket(1003, "TN02CD5678", 90.0);

        // Copy constructor
        ParkingTicket t4 = new ParkingTicket(t3);

        System.out.println("\nDefault Constructor:");
        t1.displayTicket();

        System.out.println("Parameterized Constructor:");
        t2.displayTicket();

        System.out.println("Overloaded Constructor:");
        t3.displayTicket();

        System.out.println("Copy Constructor:");
        t4.displayTicket();
    }
}
