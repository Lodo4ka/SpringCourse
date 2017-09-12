package Service;

import Entity.Event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class EventService implements Service<Event>{

    List<Event> events;

    public EventService() {
        this.events = new ArrayList<>();
    }


    @Override
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


    List<LocalDate> getForDateRange(String startDate, String endDate){
        final LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        final LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

       final long days = start.until(end, ChronoUnit.DAYS);

       return LongStream.rangeClosed(0, days)
               .mapToObj(start::plusDays)
               .collect(Collectors.toList());
    }

    List<LocalDate> getNextEvents(String endDate){

        final LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        LocalDate now = LocalDate.now();
        final long days = now.until(end, ChronoUnit.DAYS);

        return LongStream.rangeClosed(0, days)
                .mapToObj(now::plusDays)
                .collect(Collectors.toList());
    }
}
