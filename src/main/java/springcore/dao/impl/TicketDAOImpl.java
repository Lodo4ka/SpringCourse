package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import springcore.dao.TicketDAO;
import springcore.dao.impl.mapper.TicketMapper;
import springcore.entity.Event;
import springcore.entity.Ticket;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public Ticket refresh(Ticket ticket) {
        String sqlQuery = "UPDATE tickets SET event_id = ?, date_time = ?, user_id = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery, ticket.getEvent().getId(), ticket.getDateTime(), ticket.getUser().getId());
        return ticket;
    }

    @Override
    public Ticket add(Ticket ticket) {
        String sqlQuery = "INSERT INTO tickets(event_id, date_time, auditorium_seat_id, user_id) VALUES (?, ?, ?, ?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, ticket.getEvent().getId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(ticket.getDateTime()));
            preparedStatement.setLong(4, ticket.getUser().getId());
            return preparedStatement;
        }, generatedKeyHolder);

        Optional<List<Map<String, Object>>> keyList = Optional.ofNullable(generatedKeyHolder.getKeyList());

        Object id = keyList.map(item -> item.iterator().next()).map(n -> n.get("id")).orElse(null);
        ticket.setId((long) id);
        return ticket;
    }

    @Override
    public void delete(int id) {
        String sqlquery = "DELETE FROM tickets WHERE id = ?";
        jdbcTemplate.update(sqlquery, id);
    }


    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event) {
        String sqlquery = "SELECT * FROM tickets WHERE event_id = ?";
        return jdbcTemplate.query(sqlquery, new Object[]{event.getId()}, ticketMapper);
    }
}
