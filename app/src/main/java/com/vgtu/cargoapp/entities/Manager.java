package com.vgtu.cargoapp.entities;

import lombok.Data;

@Data
public class Manager extends User {
    private boolean isAdmin;
    private float bonusAmountPerKmEUR;
    private int minDistanceToGetBonus;
}
