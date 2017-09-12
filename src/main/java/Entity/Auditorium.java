package Entity;

public class Auditorium {

    String name;
    int numberOfSeats;
    int vipSeats;

    public Auditorium(String name, int numberOfSeats, int vipSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.vipSeats = vipSeats;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getVipSeats() {
        return vipSeats;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", vipSeats=" + vipSeats +
                '}';
    }
}
