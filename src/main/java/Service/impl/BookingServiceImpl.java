package Service.impl;

import Entity.Event;
import Entity.Ticket;
import Entity.User;
import Service.BookingService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    List<Ticket> tickets;

    @Override
    public long getTicketsPrice(Event event, LocalDateTime dateTime, User user, int seats) {
        return tickets.stream()
                .filter(ticket -> ticket.getEvent().equals(event) &&
                        ticket.getDateTime().equals(dateTime) &&
                        ticket.getUser().equals(user) &&
                        ticket.getSeat() == seats)
                .mapToLong(ticket -> event.getBasePrice()).sum();
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return tickets.stream().filter(ticket -> ticket.getDateTime().equals(dateTime)
                && ticket.getEvent().equals(event)).collect(Collectors.toList());
    }
}