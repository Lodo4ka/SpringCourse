package springcore.service;

import springcore.entity.Event;
import springcore.entity.Ticket;
import springcore.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService{

    long getTicketsPrice(Event event, LocalDateTime dateTime, User user, int seats);

    List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);
}
