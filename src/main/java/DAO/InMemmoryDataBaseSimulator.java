package DAO;

import Model.Auditorium;
import Model.Event;
import Model.User;

import java.util.List;

public class InMemmoryDataBaseSimulator {

    private List<User> users;
    private List<Event> events;
    private List<Auditorium> auditoriums;

    public List<User> getClient() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }


    
}
