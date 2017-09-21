package springcore.entity;

import java.time.LocalDateTime;

public class Event {

    private String name;
    private long id;
    private long basePrice;
    private LocalDateTime date;

    public Event(String name, long id, long basePrice, LocalDateTime date) {
        this.name = name;
        this.id = id;
        this.basePrice = basePrice;
        this.date = date;
    }

    public Event() {

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
                ", date= " + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (basePrice != event.basePrice) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        return date != null ? date.equals(event.date) : event.date == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (basePrice ^ (basePrice >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
