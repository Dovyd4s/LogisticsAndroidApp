package com.vgtu.cargoapp.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
public class Driver extends User implements Serializable {
    private LocalDate HealthCheckValidUntilDate;
    private LocalDate DriverLicenseValidUntilDate;

    @Override
    public String toString() {
        //return getName() +' ' + getLastName();
        return getName() + " " + getLastName() + " " + getId();
    }
}
