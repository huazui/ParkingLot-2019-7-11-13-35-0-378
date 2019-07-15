package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class story2Test {


    @Test
    public void should_errorMessage_when_fetch() {
        //given
        Car car = new Car("ZY345", false);
        Customer costomer = new Customer(car);
        ParkingLot lot = new ParkingLot(10);
        Ticket ticket = new Ticket(1);
        List<Ticket> listTickets = new ArrayList<Ticket>();
        listTickets.add(ticket);
        ParkingBoy boy = new ParkingBoy( listTickets,lot);
        costomer.setaBoy(boy);
        //when
        costomer.parking();
       costomer.setTicket(new Ticket(4));
        costomer.fetchMyCar();
        //then
        assertThat(costomer.getErrorMessage(),is("Unrecognized parking ticket."));
    }
    @Test
    public void should_get_errorMessage_when_no_ticket() {
        //given
        Car car = new Car("ZY345", false);
        Customer costomer = new Customer(car);
        ParkingLot lot = new ParkingLot(10);
        Ticket ticket = new Ticket(1);
        List<Ticket> listTickets = new ArrayList<Ticket>();
        listTickets.add(ticket);
        ParkingBoy boy = new ParkingBoy( listTickets,lot);
        costomer.setaBoy(boy);
        //when
        costomer.parking();
        costomer.setTicket(null);
        costomer.fetchMyCar();
        //then
        assertThat(costomer.getErrorMessage(),is("Please provide your parking ticket."));
    }
    @Test
    public void should_get_noPosition_when_parkingLot_isFull() {
        //given
        Car car = new Car("ZY345", false);
        Customer costomer = new Customer(car);
        ParkingLot lot = new ParkingLot(1);
        lot.getAllCar().add(new Car("ji899"));
        Ticket ticket = new Ticket(1);
        List<Ticket> listTickets = new ArrayList<Ticket>();
        listTickets.add(ticket);
        ParkingBoy boy = new ParkingBoy(listTickets, lot);
        costomer.setaBoy(boy);
        //when
        costomer.parking();
        //then
        assertThat(costomer.getErrorMessage(),is("Not enough position."));
//    }
    }


}
