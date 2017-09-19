package springcore.dao;

import springcore.entity.Event;

public interface EventDAO {

    Event create(Event event);

    Event read(Event event);

    void update(Event event);

    void delete(Event event);
}
