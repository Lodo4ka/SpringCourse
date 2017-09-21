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

@Component
public class EventDAOImpl implements EventDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Event save(Event event) {
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
        event.setId(generatedKeyHolder.getKeyList().size() == 0 ? null : (Integer) generatedKeyHolder.getKeyList().get(0).get("id"));
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
        List<Event> events = jdbcTemplate.query(sqlQuery, new Object[]{id}, new EventRowMapper());
        return events.size() > 0 ? events.get(0) : null;
    }

    @Override
    public List<Event> getall() {
        String sqlQuery = "SELECT * FROM events";
        return jdbcTemplate.query(sqlQuery, new EventRowMapper());
    }

    @Override
    public Event getByName(String name) {
        String sqlQuery = "select * from events where name = ?";
        List<Event> events = jdbcTemplate.query(sqlQuery, new Object[]{name}, new EventRowMapper());
        return events.size()>0 ? events.get(0) : null;
    }

    @Override
    public List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        String sqlQuery = "select * from events where date >= ? and date <= ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{fromDateTime, toDateTime}, new EventRowMapper());
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime dateTime) {
        String sqlQuery = "select * from events where date <= ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{dateTime}, new EventRowMapper());
    }
}
