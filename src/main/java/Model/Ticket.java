package Model;

import java.util.Date;

public class Ticket {

    private Event event;
    private Date dateTime;
    private int seat;
    private User user;

    public Ticket(Event event, Date dateTime, int seat, User user) {
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "event=" + event +
                ", dateTime=" + dateTime +
                ", seat=" + seat +
                ", user=" + user +
                '}';
    }

    public Event getEvent() {
        return event;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getSeat() {
        return seat;
    }

    public User getUser() {
        return user;
    }
}
