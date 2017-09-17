package springcore.dao;

import springcore.entity.Auditorium;
import springcore.entity.AuditoriumSeat;
import springcore.entity.Event;
import springcore.entity.User;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class InMemmoryDataBaseSimulator {

    private static List<User> users = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();
    private static List<Auditorium> auditoriums = new ArrayList<>();


    public InMemmoryDataBaseSimulator() {
        users.add(new User(1, "Max", "Lovkov", "max@mail.ru", "1234"));
        auditoriums.add(new Auditorium("Star wars"));
        auditoriums.add(new Auditorium("Deadpool"));
        events.add(new Event("Stars wars", 1, 10,
                LocalDateTime.of(2018, Month.APRIL, 20, 13, 30)));
        events.add(new Event("Deadpool", 2, 10,
                LocalDateTime.of(2017, Month.APRIL, 15, 12, 00)));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Event> getEvents() {
        return events;
    }

    public static List<Auditorium> getAuditoriums() {
        return auditoriums;
    }
}
