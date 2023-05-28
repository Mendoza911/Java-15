package org.example;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        if (t1.getDuration() < t2.getDuration()) {
            return -1;
        }
        if (t1.getDuration() > t2.getDuration()) {
            return 1;
        }
        return 0;
    }

}
