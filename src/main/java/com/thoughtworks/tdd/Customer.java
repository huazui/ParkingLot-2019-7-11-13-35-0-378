package com.thoughtworks.tdd;

/**
 * Created by twer on 3/28/14.
 */
public class Customer {
    private Ticket ticket;
    private Car car;
    ParkingBoy aBoy;
    String errorMessage="";

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public ParkingBoy getaBoy() {
        return aBoy;
    }

    public void setaBoy(ParkingBoy aBoy) {
        this.aBoy = aBoy;
    }
public boolean parking(){
        this.ticket=aBoy.getCar(this.car);
        if(!(this.ticket==null)) {
            this.car.setParking(true);
            return true;
        }
        this.setErrorMessage(aBoy.getMessage());
        return false;
}
public boolean fetchMyCar(){
        boolean successFetch=aBoy.fetchYourCar(this.ticket);
        this.setErrorMessage(aBoy.getMessage());
        if(successFetch){
            car.setParking(false);
            return true;
        }
         return false;
}
    public Customer(Car car){
        this.car=car;
    }

}
