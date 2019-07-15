package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private List<Ticket> tickets =new ArrayList<Ticket>();
    private ParkingLot parkingLot=new ParkingLot(0);
    private List<Ticket>usedTickets=new ArrayList<Ticket>();
    String message="";
    public ParkingBoy(){}
    public ParkingBoy(List<Ticket> Tickets, ParkingLot parkingLot, List<Ticket> usedTickets) {
        this.parkingLot = parkingLot;
        this.tickets = Tickets;
        this.tickets =usedTickets;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



 public ParkingBoy(List<Ticket>tickets, ParkingLot lot){
        this.tickets=tickets;
        this.parkingLot=lot;
 }
    public ParkingBoy( ParkingLot lot,List<Ticket>usedTickets){
        this.usedTickets=tickets;
        this.parkingLot=lot;
    }
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Ticket> getUesdTickets() {
        return usedTickets;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void setTickets(List<Ticket> Tickets) {
        this.tickets = Tickets;
    }

    public void setUesdTickets(List<Ticket> uesdTickets) {
        this.usedTickets = uesdTickets;
    }
  public Ticket getCar(Car car){
        if(!car.isParking()) {
            if (parkingLot.getContain() >0) {
                this.parkingLot.getPark(car);
                Ticket yourTicket = tickets.get(tickets.size() - 1);
                usedTickets.add(tickets.get(tickets.size() - 1));
                tickets.remove(tickets.size() - 1);
                yourTicket.setCar(car);
                return yourTicket;
            }
            else {
                this.message = "Not enough position.";
                return null;
            }
        }
            this.setMessage("your car is already parked");
            return null;

  }
    public boolean fetchYourCar(Ticket ticket) {
        if( ticket ==null){
            this.setMessage("Please provide your parking ticket.");
            return false;
        }
        if(usedTickets.contains(ticket)) {
            if (parkingLot.fetchCar(ticket)) {
                tickets.add(ticket);
                usedTickets=usedTickets.stream().filter(item->item.getId()!=ticket.getId()).collect(Collectors.toList());
                return true;
            }
        }
        this.setMessage("Unrecognized parking ticket.");
        return false;
    }

}





