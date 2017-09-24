package springcore.dao.impl.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import springcore.entity.Event;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class EventRowMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getInt("id"));
        event.setName(rs.getString("name"));
        event.setBasePrice(rs.getLong("baseprice"));
        event.setDate(rs.getTimestamp("date").toLocalDateTime());
        return event;
    }
}
