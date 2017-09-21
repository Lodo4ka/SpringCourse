package springcore.entity;

import java.util.List;

public class Auditorium {

    private long id;
    private String name;
    private List<AuditoriumSeat> seatList;


    public Auditorium() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuditoriumSeat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<AuditoriumSeat> seatList) {
        this.seatList = seatList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auditorium that = (Auditorium) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return seatList != null ? seatList.equals(that.seatList) : that.seatList == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (seatList != null ? seatList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatList=" + seatList +
                '}';
    }
}
