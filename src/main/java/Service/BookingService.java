package Service;

import Entity.Event;
import Entity.Ticket;
import Entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface BookingService{

    long getTicketsPrice(Event event, LocalDateTime dateTime, User user, int seats);

    List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);
}
