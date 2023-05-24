package com.vgtu.cargoapp.entities;

import lombok.Data;

import java.util.List;
@Data
public class Trip {
    private int id;
    private StopPoint startPoint;
    private StopPoint destinationPoint;
    private List<StopPoint> allRestPoints;
    private Driver assignedDriver;
    private Manager assignedManager;
    private float distance;
    private float fuelConsumed;
    private float averageSpeed;
    private Cargo cargo;

    @Override
    public String toString() {
        return "Driver=" + assignedDriver +
                ", Manager=" + assignedManager +
                "Start=" + startPoint +
                ", Destination=" + destinationPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StopPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(StopPoint startPoint) {
        this.startPoint = startPoint;
    }

    public StopPoint getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(StopPoint destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public List<StopPoint> getAllRestPoints() {
        return allRestPoints;
    }

    public void setAllRestPoints(List<StopPoint> allRestPoints) {
        this.allRestPoints = allRestPoints;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public Manager getAssignedManager() {
        return assignedManager;
    }

    public void setAssignedManager(Manager assignedManager) {
        this.assignedManager = assignedManager;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelConsumed(float fuelConsumed) {
        this.fuelConsumed = fuelConsumed;
    }

    public float getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(float averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
