package springcore.dao;

import springcore.entity.Event;
import springcore.entity.Ticket;

import java.util.List;

public interface TicketDAO {

    Ticket refresh(Ticket ticket);

    Ticket add(Ticket ticket);

    void delete(int id);

    List<Ticket> getPurchasedTicketsForEvent(Event event);


}
