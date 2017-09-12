package Entity;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    String name;
    int id;
    int basePrice;
    String rating;
    Date date;
    DateFormat df;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDf(DateFormat df) {
        this.df = df;
    }

    public Event(String name, int id, int basePrice, String rating, Date date, DateFormat df) {
        this.name = name;
        this.id = id;
        this.basePrice = basePrice;
        this.rating = rating;
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                ", date=" + date +
                ", df=" + df +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public String getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    public DateFormat getDf() {
        return df;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
