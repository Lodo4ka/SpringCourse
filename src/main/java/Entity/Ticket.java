package Entity;

import java.time.LocalDateTime;

public class Ticket {

    private long id;
    private Event event;
    private LocalDateTime dateTime;
    private int seat;
    private User user;

    public Ticket(long id, Event event, LocalDateTime dateTime, int seat, User user) {
        this.id = id;
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", event=" + event +
                ", dateTime=" + dateTime +
                ", seat=" + seat +
                ", user=" + user +
                '}';
    }
}
