package springcore.entity;


import springcore.enums.TypeofSeat;

public class AuditoriumSeat {


    private long id;
    private Auditorium auditorium;
    private int numberOfSeats;
    private int row;
    private TypeofSeat seat;


    public AuditoriumSeat() {
    }

    public AuditoriumSeat(long id, Auditorium auditorium, int numberOfSeats, int row, TypeofSeat seat) {
        this.id = id;
        this.auditorium = auditorium;
        this.numberOfSeats = numberOfSeats;
        this.row = row;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public TypeofSeat getSeat() {
        return seat;
    }

    public void setSeat(TypeofSeat seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditoriumSeat that = (AuditoriumSeat) o;

        if (id != that.id) return false;
        if (numberOfSeats != that.numberOfSeats) return false;
        if (row != that.row) return false;
        if (auditorium != null ? !auditorium.equals(that.auditorium) : that.auditorium != null) return false;
        return seat == that.seat;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        result = 31 * result + numberOfSeats;
        result = 31 * result + row;
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuditoriumSeat{" +
                "id=" + id +
                ", auditorium=" + auditorium +
                ", numberOfSeats=" + numberOfSeats +
                ", row=" + row +
                ", seat=" + seat +
                '}';
    }
}
