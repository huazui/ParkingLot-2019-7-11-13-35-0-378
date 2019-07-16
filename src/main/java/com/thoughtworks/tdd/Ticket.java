package com.thoughtworks.tdd;

public class Ticket {
    private int id;
    private Car car;
    public Ticket(int id){
        this.id=id;
    }
    public Ticket(int id, Car acar){
        this.id=id;

        this.car=acar;
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
