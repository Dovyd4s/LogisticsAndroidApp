package com.vgtu.cargoapp;

public class Constants {
    public static final String ADDRESS = "http://192.168.0.103:8080/";
    public static final String DRIVER_BY_ID_1 = ADDRESS + "driverbyID/1";
    public static final String VALIDATE_DRIVER = ADDRESS + "validatedriver";
    public static final String GET_ALL_TRIPS = ADDRESS + "allTrips";
    public static final String GET_TRIP_BY_ID = ADDRESS + "getTrip/";
    public static final String DELETE_TRIP_BY_ID = ADDRESS + "deleteTrip/";// /deleteTrip/{id}
    public static final String UPDATE_TRIP_BY_ID = ADDRESS + "updateTrip/";// /updateTrip/{id}
    public static final String GET_ALL_TRUCKS = ADDRESS + "allTrucks";
    public static final String ADD_NEW_TRUCK = ADDRESS + "addTruck";
    public static final String GET_ALL_DRIVERS = ADDRESS + "alldrivers";

}
