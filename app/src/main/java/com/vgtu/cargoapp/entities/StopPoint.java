package com.vgtu.cargoapp.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class StopPoint implements Serializable {
    private int ID;
    private String stopName;
    private String stopDescription;
    private String address;
    private String coordinates;
    private LocalDateTime timeOfArrival;
    private LocalDateTime timeOfDeparture;
}
