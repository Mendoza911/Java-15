package org.example;

import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private String from; // аэропорт откуда
    private String to; // аэропорт куда
    private int price; // цена
    private int timeFrom; // время вылета (по москве)
    private int timeTo; // время прилёта (по москве)

    public Ticket(String from, String to, int price, int timeFrom, int timeTo) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public int getDuration() {
        if (getTimeTo() > getTimeFrom()) {
            return (getTimeTo() - getTimeFrom());
        }
        if (getTimeTo() < getTimeFrom()) {
            return (getTimeTo() - getTimeFrom() + 24);
        }
        return 0;
    }


    // Вспомогательные методы для корректной работы equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return price == ticket.price && timeFrom == ticket.timeFrom && timeTo == ticket.timeTo && from.equals(ticket.from) && to.equals(ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, price, timeFrom, timeTo);
    }

    @Override
    public int compareTo(@NotNull Ticket o) {
        if (this.getPrice() < o.getPrice()) {
            return -1;
        }
        if (this.getPrice() > o.getPrice()) {
            return 1;
        }
        return 0;
    }


}
