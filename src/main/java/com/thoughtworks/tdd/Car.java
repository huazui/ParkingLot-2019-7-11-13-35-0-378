package com.thoughtworks.tdd;

public class Car {
    public  Car(String carId){
        this.carId=carId;
    }
    private String carId;
    private boolean isParking;

    public Car(String carId,boolean isParking) {
        this.carId = carId;
        this.isParking=isParking;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public boolean isParking() {
        return isParking;
    }

    public void setParking(boolean parking) {
        isParking = parking;
    }
}
