package Entity;

import Entity.Enum.TypeofSeat;

public class AuditoriumSeat {


    private Auditorium auditorium;
    private int number;
    private int row;
    private TypeofSeat seat;


    public AuditoriumSeat(Auditorium auditorium, int number, int row, TypeofSeat seat) {
        this.auditorium = auditorium;
        this.number = number;
        this.row = row;
        this.seat = seat;
    }


    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
    public String toString() {
        return "AuditoriumSeat{" +
                "auditorium=" + auditorium +
                ", number=" + number +
                ", row=" + row +
                ", seat=" + seat +
                '}';
    }
}
