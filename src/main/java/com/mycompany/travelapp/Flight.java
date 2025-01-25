package com.mycompany.travelapp;

/**
 *
 * @author dhair
 */

import java.util.Random;

public class Flight {
    int confirmationNumber;
    String passengerName;
    String originCity;
    String destinationCity;
    String date;
    int passengers;
    double price;
    Random random = new Random();
    
    Flight() {
        confirmationNumber = random.nextInt(1000000, 9999999);
        price = random.nextInt(999, 9900);
        passengers = random.nextInt(40, 140);
    }
    
    //Getters
    String getPassengerName() {
        return passengerName;
    }
    
    String getOriginCity() {
        return originCity;
    }
    
    String getDestinationCity() {
        return destinationCity;
    }
    
    String getDate() {
        return date;
    }
    
    //Setters
    void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    
    void setOriginCity(String originCity) {
        this.originCity = originCity;
    }
    
    void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
    
    void setDate(String date) {
        this.date = date;
    }
}
