
package com.parking.model;

public class Vehicle {
    private String regNo;
    private String vehicleType;
    private int parkingHours;

    public Vehicle(String regNo, String vehicleType, int parkingHours) {
        this.regNo = regNo;
        this.vehicleType = vehicleType;
        setParkingHours(parkingHours);
    }

    public String getRegNo() {
        return regNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getParkingHours() {
        return parkingHours;
    }

    public void setParkingHours(int parkingHours) {
        if (parkingHours > 0) {
            this.parkingHours = parkingHours;
        } else {
            System.out.println("Invalid parking hours!");
        }
    }

    public double calculateFee() {
        return parkingHours * 30.0;
    }
}
