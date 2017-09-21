package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import springcore.dao.AuditoriumSeatDAO;
import springcore.dao.EventDAO;
import springcore.dao.TicketDAO;
import springcore.dao.UserDAO;
import springcore.dao.impl.mapper.TicketMapper;
import springcore.entity.Event;
import springcore.entity.Ticket;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;


    @Override
    public Ticket save(Ticket ticket) {
        String sqlQuery = "UPDATE tickets SET event_id = ?, date_time = ?, auditorium_seat_id = ?, user_id = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery, ticket.getEvent().getId(), ticket.getDateTime(),
                ticket.getAuditoriumSeat().getId(), ticket.getUser().getId());
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
            preparedStatement.setLong(3,ticket.getAuditoriumSeat().getId());
            preparedStatement.setLong(4, ticket.getUser().getId());
            return preparedStatement;
        }, generatedKeyHolder);
        ticket.setId(generatedKeyHolder.getKeyList().size() == 0 ? null : (Integer) generatedKeyHolder.getKeyList().get(0).get("id"));
        return ticket;
    }

    @Override
    public void delete(int id) {
        String sqlquery = "delete from tickets where id = ?";
        jdbcTemplate.update(sqlquery, id);
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event) {
        String sqlquery = "Select * from tickets WHERE event_id = ?";
        return jdbcTemplate.query(sqlquery, new Object[]{event.getId()}, new TicketMapper(eventDAO, userDAO, auditoriumSeatDAO));
    }
}
