
import java.time.LocalDateTime;

public class Task02 {

    // Jagged array: each floor can have different slots
    static String[][] slots;

    static void initializeParking(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];

        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }
    }

    // Allocate a parking slot
    static void allocateSlot(String vehicleNo) {
        for (int floor = 0; floor < slots.length; floor++) {
            for (int slot = 0; slot < slots[floor].length; slot++) {

                if (slots[floor][slot] == null) {
                    slots[floor][slot] = vehicleNo;

                    System.out.println("Vehicle: " + vehicleNo);
                    System.out.println("Floor: " + (floor + 1));
                    System.out.println("Slot: " + (slot + 1));
                    System.out.println("Status: Parking Successful");
                    return;
                }
            }
        }

        System.out.println("Parking Full!");
    }

    // Calculate parking fee
    static double calculateFee(int minutes, double ratePerHour) {

        // Calculate started hours using integer arithmetic
        int hours = (minutes + 59) / 60;

        return hours * ratePerHour;
    }

    public static void main(String[] args) {

        // Data types
        int floorNo = 1;
        int slotNo = 101;
        String vehicleNo = "TN01AB1234";
        LocalDateTime entryTime = LocalDateTime.now();
        double ratePerHour = 30.0;
        int parkingMinutes = 90;

        // Different number of slots on each floor
        int[] slotsPerFloor = {3, 2, 4};

        initializeParking(slotsPerFloor);

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("---------------------------");

        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Entry Time: " + entryTime);

        System.out.println();

        allocateSlot(vehicleNo);

        System.out.println();

        double fee = calculateFee(parkingMinutes, ratePerHour);

        System.out.println("Parking Duration: " + parkingMinutes + " minutes");
        System.out.println("Rate Per Hour: Rs " + ratePerHour);
        System.out.println("Parking Fee: Rs " + fee);

        System.out.println();

        // Demonstrating integer division problem
        System.out.println("Integer Division: " + (90 / 60));
        System.out.println("Correct Billable Hours: " + ((90 + 59) / 60));

    }
}