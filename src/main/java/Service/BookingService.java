package Service;

import Entity.Event;
import Entity.Ticket;
import Entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingService implements Service<Ticket>{

    List<Ticket> tickets;

    public BookingService() {
        this.tickets = new ArrayList<>();
    }

    //возвращает общую стоимость всех билетов на указанное событие в определенные даты и время для указанных мест.
    int getTicketsPrice(Event event, Date dateTime, User user, int seats){
        tickets.stream().filter(event -> event.getDateTime().equals(dateTime)
                && event.getUser().equals(user) && event.getSeat() == seats).;
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

    @Override
    public void save(Ticket ticket) {

    }

    @Override
    public void remove(Ticket ticket) {

    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public Ticket getByName(String name) {
        return null;
    }

    @Override
    public Ticket getById(int id) {
        return null;
    }
}
