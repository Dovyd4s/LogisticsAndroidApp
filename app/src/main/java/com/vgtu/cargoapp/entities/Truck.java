package com.vgtu.cargoapp.entities;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Truck {
    private String VIN;
    private String plateNumber;
    private String Make;
    private String Model;
    private float weightTonnes;
    private float maxCapacityTonnes;
    private float averageFuelConsumption;
    private float tankSizeLiters;
    private LocalDate manufacturedDate;
    private LocalDate lastTechnicalStateCheckDate;

    @Override
    public String toString() {
        return  "VIN='" + VIN + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", weightTonnes=" + weightTonnes +
                ", maxCapacityTonnes=" + maxCapacityTonnes +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", tankSizeLiters=" + tankSizeLiters +
                ", manufacturedDate=" + manufacturedDate +
                ", lastTechnicalStateCheckDate=" + lastTechnicalStateCheckDate +
                '}';
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public float getWeightTonnes() {
        return weightTonnes;
    }

    public void setWeightTonnes(float weightTonnes) {
        this.weightTonnes = weightTonnes;
    }

    public float getMaxCapacityTonnes() {
        return maxCapacityTonnes;
    }

    public void setMaxCapacityTonnes(float maxCapacityTonnes) {
        this.maxCapacityTonnes = maxCapacityTonnes;
    }

    public float getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(float averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public float getTankSizeLiters() {
        return tankSizeLiters;
    }

    public void setTankSizeLiters(float tankSizeLiters) {
        this.tankSizeLiters = tankSizeLiters;
    }

    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(LocalDate manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public LocalDate getLastTechnicalStateCheckDate() {
        return lastTechnicalStateCheckDate;
    }

    public void setLastTechnicalStateCheckDate(LocalDate lastTechnicalStateCheckDate) {
        this.lastTechnicalStateCheckDate = lastTechnicalStateCheckDate;
    }
}
