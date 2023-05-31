import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void CompareToTest () {

        Ticket ticket = new Ticket("Чита", "Москва", 123, 12, 16);
        Ticket ticket1 = new Ticket("Чита1", "Москва1", 124, 12, 16);
        Ticket ticket2 = new Ticket("Чита1", "Москва1", 124, 12, 16);

        Assertions.assertEquals(-1, ticket.compareTo(ticket1));

        Assertions.assertEquals(0, ticket1.compareTo(ticket2));

        Assertions.assertEquals(1, ticket2.compareTo(ticket));
    }

    @Test
    public void SearchAndCompare () {

        Ticket ticket1 = new Ticket("Чита1", "Москва1", 124, 12, 16);
        Ticket ticket2 = new Ticket("Чита", "Москва", 123, 12, 16);
        Ticket ticket3 = new Ticket("Чита3", "Москва3", 122, 12, 16);
        Ticket ticket4 = new Ticket("Чита", "Москва", 121, 12, 16);
        Ticket ticket5 = new Ticket("Чита5", "Москва5", 120, 12, 16);
        Ticket ticket6 = new Ticket("Чита", "Москва", 125, 12, 16);

        AviaSouls AS = new AviaSouls();

        AS.add(ticket1);
        AS.add(ticket2);
        AS.add(ticket3);
        AS.add(ticket4);
        AS.add(ticket5);
        AS.add(ticket6);

        Ticket[] expect = {ticket4, ticket2, ticket6};
        Ticket[] actual = AS.search("Чита", "Москва");

        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void ticketTimeComparator () {

        Ticket ticket1 = new Ticket("Чита1", "Москва1", 124, 12, 14);
        Ticket ticket2 = new Ticket("Чита", "Москва", 123, 12, 16);
        Ticket ticket3 = new Ticket("Чита1", "Москва1", 124, 12, 23);
        Ticket ticket4 = new Ticket("Чита", "Москва", 123, 12, 16);
        Ticket ticket5 = new Ticket("Чита1", "Москва1", 124, 12, 16);
        Ticket ticket6 = new Ticket("Чита", "Москва", 123, 12, 16);

        TicketTimeComparator TTC = new TicketTimeComparator();

        int expect = -1;
        int actual = TTC.compare(ticket1, ticket2);
        Assertions.assertEquals(expect, actual);

        Assertions.assertEquals(1, TTC.compare(ticket3, ticket4));

        Assertions.assertEquals(0, TTC.compare(ticket5, ticket6));
    }

    @Test
    public void searchAndSortByComparatorSomeTicket () {

        Ticket ticket1 = new Ticket("Чита1", "Москва1", 124, 12, 16);
        Ticket ticket2 = new Ticket("Чита", "Москва", 123, 12, 14);
        Ticket ticket3 = new Ticket("Чита3", "Москва3", 122, 12, 16);
        Ticket ticket4 = new Ticket("Чита", "Москва", 121, 12, 22);
        Ticket ticket5 = new Ticket("Чита5", "Москва5", 120, 12, 16);
        Ticket ticket6 = new Ticket("Чита", "Москва", 125, 12, 17);

        TicketTimeComparator comparator = new TicketTimeComparator();

        AviaSouls AS = new AviaSouls();

        AS.add(ticket1);
        AS.add(ticket2);
        AS.add(ticket3);
        AS.add(ticket4);
        AS.add(ticket5);
        AS.add(ticket6);

        Ticket[] expect = {ticket2, ticket6, ticket4};
        Ticket[] actual = AS.searchAndSortBy("Чита", "Москва", comparator);

        Assertions.assertArrayEquals(expect, actual);
       }

    @Test
    public void searchAndSortByComparatorOneTicket () {

        Ticket ticket1 = new Ticket("Чита1", "Москва1", 124, 12, 16);
        Ticket ticket2 = new Ticket("Чита2", "Москва2", 123, 12, 15);
        Ticket ticket3 = new Ticket("Чита3", "Москва3", 122, 12, 14);
        Ticket ticket4 = new Ticket("Чита4", "Москва4", 121, 12, 13);
        Ticket ticket5 = new Ticket("Чита5", "Москва5", 120, 12, 12);
        Ticket ticket6 = new Ticket("Чита6", "Москва6", 125, 12, 11);

        TicketTimeComparator comparator = new TicketTimeComparator();

        AviaSouls AS = new AviaSouls();

        AS.add(ticket1);
        AS.add(ticket2);
        AS.add(ticket3);
        AS.add(ticket4);
        AS.add(ticket5);
        AS.add(ticket6);

        Ticket[] expect = {ticket6};
        Ticket[] actual = AS.searchAndSortBy("Чита6", "Москва6", comparator);

        Assertions.assertArrayEquals(expect, actual);

    }

    @Test
    public void searchAndSortByComparatorNoTicket () {

        Ticket ticket1 = new Ticket("Чита1", "Москва1", 124, 12, 16);
        Ticket ticket2 = new Ticket("Чита2", "Москва2", 123, 12, 15);
        Ticket ticket3 = new Ticket("Чита3", "Москва3", 122, 12, 14);
        Ticket ticket4 = new Ticket("Чита4", "Москва4", 121, 12, 13);
        Ticket ticket5 = new Ticket("Чита5", "Москва5", 120, 12, 12);
        Ticket ticket6 = new Ticket("Чита6", "Москва6", 125, 12, 11);

        TicketTimeComparator comparator = new TicketTimeComparator();

        AviaSouls AS = new AviaSouls();

        AS.add(ticket1);
        AS.add(ticket2);
        AS.add(ticket3);
        AS.add(ticket4);
        AS.add(ticket5);
        AS.add(ticket6);

        Ticket[] expect = {};
        Ticket[] actual = AS.searchAndSortBy("Чита7", "Москва7", comparator);

        Assertions.assertArrayEquals(expect, actual);

    }

}