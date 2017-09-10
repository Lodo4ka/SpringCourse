package Service;

import Model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventService implements Service{

    List<Event> events;

    public EventService() {
        this.events = new ArrayList<>();
    }

    public void save(Event event) {
        events.add(event);
    }

    public void remove(Event event) {
        events.remove(event);
    }


    @Override
    public List<Event>  getAll() {
        return events;
    }

    @Override
    public Event getByName(String name) {
        for (Event event : events) {
            if(name.equals(event.getName())){
                return event;
            }
        }

        return null;
    }

    @Override
    public Event getById(int id) {
        for (Event event : events) {
            if(id == event.getId()){
                return event;
            }
        }
        return null;
    }


    List<Event> getForDateRange(Date from, Date to){

    }

    List<Event> getNextEvents(Date to){
        
    }
}
