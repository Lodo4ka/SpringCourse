package Service;

import Model.Event;
import Model.Ticket;
import Model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingService {

    List<Ticket> tickets;

    public BookingService() {
        this.tickets = new ArrayList<>();
    }

    //возвращает общую стоимость всех билетов на указанное событие в определенные даты и время для указанных мест.
    int getTicketsPrice(Event event, Date dateTime, User user, int seats){
        //i don't know which text i can write this scope

    }

    void bookTicket(Ticket ticket){
        System.out.println(ticket);
    }


    // получает все купленые билеты на event по конкретной дате и времени.
    Ticket getPurchasedTicketsForEvent(Event event, Date dateTime){
        for (Ticket ticket : tickets) {
            if(event.equals(ticket.getEvent()) && dateTime.equals(ticket.getDateTime())){
                return ticket;
            }
        }
        return null;
    }
}
