package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TicketsManager {
    Repository repository;

    public TicketsManager(Repository repository) {
        this.repository = repository;
    }


    public Tickets[] searchByFromAndTo(String text) {
        Tickets[] result = new Tickets[0];
        for (Tickets ticket : repository.findAll()) {
            if (ticket.getDepartureAirport().contains(text)) {
                Tickets[] tmp = new Tickets[result.length + 1];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
            if (ticket.getArrivalAirport().contains(text)) {
                Tickets[] tmp = new Tickets[result.length + 1];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


    // public Tickets[] searchByTo(String text) {
    //   Tickets[] result = new Tickets[0];
    // for (Tickets ticket : repository.findAll()) {
    //   if (ticket.getArrivalAirport().contains(text)) {
    //     Tickets[] tmp = new Tickets[result.length + 1];
    //   for (int i = 0; i < result.length; i++) {
    //     tmp[i] = result[i];
    //}
    //tmp[tmp.length - 1] = ticket;
    //result = tmp;
    // }
    // }
    // Arrays.sort(result);
    // return result;
    //}


}
