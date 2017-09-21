package springcore.entity;

import java.time.LocalDateTime;

public class Ticket {

    private long id;
    private Event event;
    private LocalDateTime dateTime;
    private AuditoriumSeat auditoriumSeat;
    private User user;


    public Ticket() {
    }

    public Ticket(long id, Event event, LocalDateTime dateTime, AuditoriumSeat auditoriumSeat, User user) {
        this.id = id;
        this.event = event;
        this.dateTime = dateTime;
        this.auditoriumSeat = auditoriumSeat;
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

    public AuditoriumSeat getAuditoriumSeat() {
        return auditoriumSeat;
    }

    public void setAuditoriumSeat(AuditoriumSeat auditoriumSeat) {
        this.auditoriumSeat = auditoriumSeat;
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
                ", auditoriumSeat=" + auditoriumSeat +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (event != null ? !event.equals(ticket.event) : ticket.event != null) return false;
        if (dateTime != null ? !dateTime.equals(ticket.dateTime) : ticket.dateTime != null) return false;
        if (auditoriumSeat != null ? !auditoriumSeat.equals(ticket.auditoriumSeat) : ticket.auditoriumSeat != null)
            return false;
        return user != null ? user.equals(ticket.user) : ticket.user == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (auditoriumSeat != null ? auditoriumSeat.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
