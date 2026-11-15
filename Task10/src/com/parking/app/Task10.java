
package com.parking.app;

import com.parking.model.Vehicle;

public class Task10 {
    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        Vehicle v1 = new Vehicle("TN01AB1234", "Car", 3);

        System.out.println("\nVehicle Details:");
        System.out.println("Registration Number: " + v1.getRegNo());
        System.out.println("Vehicle Type: " + v1.getVehicleType());
        System.out.println("Parking Hours: " + v1.getParkingHours());

        System.out.println("Parking Fee: Rs " + v1.calculateFee());

        System.out.println("\nUpdating Parking Hours:");
        v1.setParkingHours(5);

        System.out.println("New Parking Hours: " + v1.getParkingHours());
        System.out.println("Updated Parking Fee: Rs " + v1.calculateFee());

        System.out.println("\nTesting Encapsulation:");
        v1.setParkingHours(-2);

        System.out.println("Final Parking Hours: " + v1.getParkingHours());
    }
}
