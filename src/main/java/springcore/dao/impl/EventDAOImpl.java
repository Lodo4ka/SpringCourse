package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import springcore.dao.EventDAO;
import springcore.dao.impl.mapper.EventRowMapper;
import springcore.entity.Event;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class EventDAOImpl implements EventDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EventRowMapper eventRowMapper;

    @Override
    public Event refresh(Event event) {
        String sqlQuery = "UPDATE events SET name = ?, baseprice = ?, date = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery, event.getName(), event.getBasePrice(), event.getDate());
        return event;
    }

    @Override
    public Event add(Event event) {
        String sqlQuery = "INSERT INTO events(name, baseprice, date) VALUES(?,?,?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getName());
            preparedStatement.setLong(2, event.getBasePrice());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(event.getDate()));
            return preparedStatement;
        }, generatedKeyHolder);
        Optional<List<Map<String, Object>>> keyList = Optional.ofNullable(generatedKeyHolder.getKeyList());
        Object id = keyList.map(item -> item.iterator().next()).map(n -> n.get("id")).orElse(null);
        event.setId((long) id);
        return event;
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM events WHERE id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public Event getById(int id) {
        String sqlQuery = "SELECT FROM events WHERE id = ?";
        List<Event> events = jdbcTemplate.query(sqlQuery, new Object[]{id}, eventRowMapper);
        return events.size() > 0 ? events.get(0) : null;
    }

    @Override
    public List<Event> getall() {
        String sqlQuery = "SELECT * FROM events";
        return jdbcTemplate.query(sqlQuery, eventRowMapper);
    }

    @Override
    public Event getByName(String name) {
        String sqlQuery = "select * from events where name = ?";
        List<Event> events = jdbcTemplate.query(sqlQuery, new Object[]{name}, eventRowMapper);
        return events.size()>0 ? events.get(0) : null;
    }

    @Override
    public List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        String sqlQuery = "select * from events where date >= ? and date <= ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{fromDateTime, toDateTime}, eventRowMapper);
}

    @Override
    public List<Event> getNextEvents(LocalDateTime dateTime) {
        String sqlQuery = "select * from events where date <= ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{dateTime}, eventRowMapper);
    }
}
