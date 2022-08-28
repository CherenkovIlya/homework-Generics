package org.example;

public class Repository {


    Tickets[] tickets = new Tickets[0];


    public void add(Tickets ticket) {
        Tickets[] tmp = new Tickets[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }


    public void removeById(int removeId) {
        if (findById(removeId) == null) {
            throw new NotFoundException("Element with id: " + removeId + " not found");
        }

        Tickets[] tmp = new Tickets[tickets.length - 1];
        int index = 0;
        for (Tickets tickets : tickets) {
            if (tickets.getId() != removeId) {
                tmp[index] = tickets;
                index++;
            }
        }
        tickets = tmp;
    }

    public Tickets findById(int id) {
        Tickets result = null;
        for (Tickets ticket : tickets) {
            if (ticket.getId() == id) {
                result = ticket;
                break;
            }
        }
        return result;
    }


    public Tickets[] findAll() {

        return tickets;
    }

}
