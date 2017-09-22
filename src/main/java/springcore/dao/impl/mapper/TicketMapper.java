package springcore.dao.impl.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import springcore.dao.EventDAO;
import springcore.dao.UserDAO;
import springcore.entity.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class TicketMapper implements RowMapper<Ticket> {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getInt("id"));
        ticket.setEvent(eventDAO.getById(rs.getInt("event_id")));
        ticket.setUser(userDAO.getById(rs.getInt("user_id")));
        return ticket;
    }
}
