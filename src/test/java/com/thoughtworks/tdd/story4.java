package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class story4 {
    @Test
    public void should_parking_in_more() {
        //given
        Car car = new Car("ZY345", false);
        Customer costomer = new Customer(car);
        ParkingLot lot = new ParkingLot(7);
        ParkingLot anotherLot=new ParkingLot(17);
        ParkingLot otherLot=new ParkingLot(9);
        List<ParkingLot>lots=new ArrayList<ParkingLot>();
        lots.add(lot);
        lots.add(anotherLot);
        lots.add(otherLot);
        Ticket ticket = new Ticket(1);
        List<Ticket> listTickets = new ArrayList<Ticket>();
        listTickets.add(ticket);
        SmartParkingBay boy = new SmartParkingBay( lots,listTickets);
        costomer.setaBoy(boy);
        //when
        boolean u=costomer.parking();
        ParkingLot testLot=boy.getParkingLot();
        //then
        assertThat(testLot.getContain(),is(16));
    }
}
