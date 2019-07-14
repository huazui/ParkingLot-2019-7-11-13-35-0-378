package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class CustomerTest {
    @Test
    public void AC1Test() {
         Car car = new Car("ZY345", false);
        Customer costomer = new Customer(car);
        ParkingLot lot = new ParkingLot(0);
        Ticket ticket = new Ticket(1);
        List<Ticket> listTickets = new ArrayList<Ticket>();
        listTickets.add(ticket);
        ParkingBoy boy = new ParkingBoy( listTickets,lot);
        costomer.setaBoy(boy);
        assertThat(costomer.parking(),is(true));
        assertThat(costomer.getTicket().getId(),is(1));
        assertThat(costomer.getCar().isParking(),is(true));
        assertThat(lot.getLimit(),is(1));
        assertThat(costomer.fetchMyCar(),is(true));
        assertThat(costomer.getCar().isParking(),is(false));


    }
}