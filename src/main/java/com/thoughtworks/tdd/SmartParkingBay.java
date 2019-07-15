package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBay extends ParkingBoy {
    private List<Ticket> tickets =new ArrayList<Ticket>();
    private List<ParkingLot> parkingLots=new ArrayList<ParkingLot>();
    private ParkingLot parkingLot;
    private List<Ticket>usedTickets=new ArrayList<Ticket>();
    String message="";
    public SmartParkingBay(List<Ticket> Tickets, List<ParkingLot> parkingLot, List<Ticket> usedTickets) {
        this.parkingLots = parkingLot;
        this.tickets = Tickets;
        this.tickets =usedTickets;
    }
    public SmartParkingBay(List<ParkingLot> parkingLot, List<Ticket> ticket){
        this.parkingLots=parkingLot;
        this.tickets=ticket;
    }
   public Ticket getCar(Car car) {
       List<ParkingLot> sortedLot = parkingLots.stream().sorted(Comparator.comparingInt(ParkingLot::getContain)).collect(Collectors.toList());
       parkingLot = sortedLot.get(sortedLot.size() - 1);
       if (!car.isParking()) {
           if (parkingLot.getContain() > 0) {
               this.parkingLot.getPark(car);
               Ticket yourTicket = tickets.get(tickets.size() - 1);
               usedTickets.add(tickets.get(tickets.size() - 1));
               tickets.remove(tickets.size() - 1);
               yourTicket.setCar(car);
               return yourTicket;
           } else {
               this.message = "Not enough position.";
               return null;
           }
       }
       this.setMessage("your car is already parked");
       return null;
   }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setParkingLot(List<ParkingLot> parkingLot) {
        this.parkingLots = parkingLot;
    }

    @Override
    public void setUesdTickets(List<Ticket> uesdTickets) {
        super.setUesdTickets(uesdTickets);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public List<Ticket> getUesdTickets() {
        return this.usedTickets;
    }

    public List<ParkingLot> getParkingLotList() {
        return this.parkingLots;
    }
}
