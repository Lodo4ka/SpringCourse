package Entity;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Event {

    String name;
    long id;
    long basePrice;
    LocalDateTime date;




    public Event(String name, long id, long basePrice, LocalDateTime date) {
        this.name = name;
        this.id = id;
        this.basePrice = basePrice;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", basePrice=" + basePrice +
                ", date=" + date +
                '}';
    }
}
