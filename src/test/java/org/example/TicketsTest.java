package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsTest {

    Repository repo = new Repository();
    TicketsManager manager = new TicketsManager(repo);


    Tickets ticket1 = new Tickets(1, 1000, "VNO", "BCN", 240);
    Tickets ticket2 = new Tickets(2, 1000, "BCN", "VNO", 240);


    @Test
    public void setId() {
        ticket1.setId(3);

        int expected = 3;
        int actual = ticket1.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setPrice() {
        ticket2.setPrice(1200);

        int expected = 1200;
        int actual = ticket2.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setDepartureAirport() {
        ticket1.setDepartureAirport("WAW");

        String expected = "WAW";
        String actual = ticket1.getDepartureAirport();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setArrivalAirport() {
        ticket2.setArrivalAirport("WAW");

        String expected = "WAW";
        String actual = ticket2.getArrivalAirport();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setTravelTime() {
        ticket1.setTravelTime(250);

        int expected = 250;
        int actual = ticket1.getTravelTime();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.removeById(1);
        Tickets[] expected = {ticket2};
        Tickets[] actual = repo.findAll();
    }

    @Test
    public void removeByIdExceptions() {
        repo.add(ticket1);
        repo.add(ticket2);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(3)
        );
    }


    @Test
    public void searchByFromAndTo() {
        repo.add(ticket1);
        repo.add(ticket2);

        Tickets[] expected = {ticket1, ticket2};
        Tickets[] actual = manager.searchByFromAndTo("BCN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByFromAll() {
        repo.add(ticket1);
        repo.add(ticket2);
        //ticket2.setDepartureAirport("VNO");

        Tickets[] expected = {ticket1, ticket2};
        Tickets[] actual = manager.searchByFromAndTo("VNO");

        Assertions.assertArrayEquals(expected, actual);
    }

    // @Test
    // public void searchByTo() {
    // repo.add(ticket1);
    //repo.add(ticket2);

    //Tickets[] expected = { ticket1};
    //Tickets[] actual = manager.searchByTo("BCN");

    // Assertions.assertArrayEquals(expected, actual);
    //}

    //@Test
    //public void searchByToAll() {
    //  repo.add(ticket1);
    // repo.add(ticket2);
    // ticket2.setArrivalAirport("BCN");

    // Tickets[] expected = { ticket1, ticket2};
    // Tickets[] actual = manager.searchByTo("BCN");

    //  Assertions.assertArrayEquals(expected, actual);
    // }

    @Test
    public void compareToEquals() {
        repo.add(ticket1);
        repo.add(ticket2);

        Tickets[] tickets = {ticket1, ticket2};
        Arrays.sort(tickets);
    }

    @Test
    public void compareToLess() {
        ticket1.setPrice(900);
        repo.add(ticket1);
        repo.add(ticket2);

        Tickets[] tickets = {ticket1, ticket2};
        Arrays.sort(tickets);
    }

    @Test
    public void compareToMore() {
        ticket1.setPrice(1100);
        repo.add(ticket1);
        repo.add(ticket2);

        Tickets[] tickets = {ticket1, ticket2};
        Arrays.sort(tickets);
    }

}
