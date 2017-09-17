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
        auditoriums.add(new Auditorium("Russian"));
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
