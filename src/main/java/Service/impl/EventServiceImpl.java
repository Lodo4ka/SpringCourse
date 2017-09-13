package Service.impl;

import DAO.InMemmoryDataBaseSimulator;
import Entity.Event;
import Service.EventService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class EventServiceImpl implements EventService {


    @Override
    public void save(Event event) {
        InMemmoryDataBaseSimulator.getEvents().add(event);
    }

    @Override
    public void remove(Event event) {
        InMemmoryDataBaseSimulator.getEvents().remove(event);
    }

    @Override
    public Event getById(long id) {
        return InMemmoryDataBaseSimulator.getEvents().stream().filter(e -> e.getId() == id).findFirst().get();
    }

    @Override
    public Event getByName(String name) {
        return InMemmoryDataBaseSimulator.getEvents().stream().filter(n -> n.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<Event> getAll() {
        return InMemmoryDataBaseSimulator.getEvents();
    }

    @Override
    public List<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {

        final long days = from.until(to, ChronoUnit.DAYS);

        //how to transform List<LocalDateTime> to List<Event>
        return InMemmoryDataBaseSimulator.getEvents().stream()
                .filter(event -> {
                    long start = from.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long end = to.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    long current = event.getDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                    return current >= start && current <= end;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime to) {

        LocalDateTime now = LocalDateTime.now();

        final long days = now.until(to, ChronoUnit.DAYS);

        //how to transform List<LocalDateTime> to List<Event>
        return LongStream.rangeClosed(0, days).mapToObj(now::plusDays).collect(Collectors.toList());
    }
}
