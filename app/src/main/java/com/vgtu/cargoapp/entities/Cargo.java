package com.vgtu.cargoapp.entities;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Cargo {
    private long Id;
    private CargoType cargoType;
    private LocalDate mustBeDeliveredUntilDate;
    private LocalDate readyForPickUpDate;
    private float valueOfCargoEUR;
    private float totalCargoWeightTonnes;
}
