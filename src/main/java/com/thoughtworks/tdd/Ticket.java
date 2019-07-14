package com.thoughtworks.tdd;

public class Ticket {
    private int id;
    private Car car;
    public Ticket(int id){
        this.id=id;
    }
    public Ticket(int id, Car car){
        this.id=id;

        this.car=car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }




}
