package springcore.dao;

import springcore.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventDAO {

    Event save(Event event);

    Event add(Event event);

    void delete(int id);

    Event getById(int id);

    List<Event> getall();

    Event getByName(String name);

    List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime toDateTime);

    List<Event> getNextEvents(LocalDateTime dateTime);
}
