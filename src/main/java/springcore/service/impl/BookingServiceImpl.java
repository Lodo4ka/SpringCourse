package springcore.service.impl;

import org.springframework.stereotype.Service;
import springcore.entity.Event;
import springcore.entity.Ticket;
import springcore.entity.User;
import springcore.service.BookingService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class BookingServiceImpl implements BookingService {

    List<Ticket> tickets;

    @Override
    public long getTicketsPrice(Event event, LocalDateTime dateTime, User user, int seats) {
        return tickets.stream()
                .filter(ticket -> ticket.getEvent().equals(event) &&
                        ticket.getDateTime().equals(dateTime) &&
                        ticket.getUser().equals(user))
                .mapToLong(ticket -> event.getBasePrice()).sum();
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return tickets.stream().filter(ticket -> ticket.getDateTime().equals(dateTime)
                && ticket.getEvent().equals(event)).collect(Collectors.toList());
    }
}