
class ParkingTicket {
    private static int nextTicketNumber;

    private int ticketNumber;
    private String vehicleNumber;

    // Static block: class load aagumbothu once execute aagum
    static {
        nextTicketNumber = 1000;
        System.out.println("Parking Ticket System Initialized");
    }

    public ParkingTicket(String vehicleNumber) {
        this.ticketNumber = ++nextTicketNumber;
        this.vehicleNumber = vehicleNumber;
    }

    public static int getTotalTicketsIssued() {
        return nextTicketNumber - 1000;
    }

    public void displayTicket() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Vehicle Number: " + vehicleNumber);
    }
}

class ParkingFacility {
    private String gateName;
    private int occupancy;

    public ParkingFacility(String gateName) {
        this.gateName = gateName;
        this.occupancy = 0;
    }

    public ParkingTicket issueTicket(String vehicleNumber) {
        occupancy++;
        return new ParkingTicket(vehicleNumber);
    }

    public void releaseTicket(ParkingTicket ticket) {
        if (ticket != null && occupancy > 0) {
            occupancy--;
            System.out.println("Vehicle exited from " + gateName);
        }
    }

    public void displayOccupancy() {
        System.out.println(gateName + " Occupancy: " + occupancy);
    }
}

public class Task05 {
    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        ParkingFacility northGate = new ParkingFacility("North Gate");
        ParkingFacility southGate = new ParkingFacility("South Gate");

        ParkingTicket t1 = northGate.issueTicket("TN01AB1234");
        ParkingTicket t2 = southGate.issueTicket("TN02CD5678");
        ParkingTicket t3 = northGate.issueTicket("TN03EF9012");

        System.out.println("\nIssued Tickets:");
        t1.displayTicket();
        t2.displayTicket();
        t3.displayTicket();

        System.out.println("\nTotal Tickets: "
                + ParkingTicket.getTotalTicketsIssued());

        System.out.println("\nFacility Occupancy:");
        northGate.displayOccupancy();
        southGate.displayOccupancy();

        System.out.println("\nVehicle Exit:");
        northGate.releaseTicket(t1);

        // t1 reference remove pannrom
        t1 = null;

        System.out.println("Ticket reference set to null.");
        System.out.println("Object is eligible for Garbage Collection.");

        System.out.println("\nFinal Occupancy:");
        northGate.displayOccupancy();
        southGate.displayOccupancy();
    }
}
