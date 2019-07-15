package com.thoughtworks.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class CustomerTest {
    Car car = new Car("ZY345", false);
    Customer costomer = new Customer(car);
    ParkingLot lot = new ParkingLot(10);
    Ticket ticket = new Ticket(1);
    @Test
    public void should_return_true_when_parking() {
        List<Ticket> listTickets = new ArrayList<Ticket>();
        listTickets.add(ticket);
        ParkingBoy boy = new ParkingBoy( listTickets,lot);
        costomer.setaBoy(boy);
        boolean parking=costomer.parking();
        assertThat(parking,is(true));
    }
@Test
    public void should_return_ticket_when_parking_and_getTicket() {
        List<Ticket> listTickets = new ArrayList<Ticket>();
        listTickets.add(ticket);
        ParkingBoy boy = new ParkingBoy( listTickets,lot);
        costomer.setaBoy(boy);
        boolean parking=costomer.parking();
        int ticketId=costomer.getTicket().getId();
        assertThat(ticketId,is(1));
        assertThat(costomer.fetchMyCar(),is(true));
        assertThat(costomer.getCar().isParking(),is(false));

    }
    @Test
    public void should_return_true_when_fetch_car() {
        List<Ticket> listTickets = new ArrayList<Ticket>();
        listTickets.add(ticket);
        ParkingBoy boy = new ParkingBoy( listTickets,lot);
        costomer.setaBoy(boy);
        boolean parking=costomer.parking();
        int ticketId=costomer.getTicket().getId();
        boolean fetch=costomer.fetchMyCar();
        assertThat(fetch,is(true));

    }
}