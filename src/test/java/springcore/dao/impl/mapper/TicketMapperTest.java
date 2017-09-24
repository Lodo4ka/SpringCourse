package springcore.dao.impl.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springcore.dao.EventDAO;
import springcore.dao.UserDAO;
import springcore.entity.Ticket;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TicketMapperTest extends BaseTest {


    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;


    @Test
    public void mapRow() {
        //expected data
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticket.setEvent(eventDAO.getById(1));
        ticket.setUser(userDAO.getById(1));

        // actual data && given
//        assertTrue("Ticket id is null", ticket.getId() > 0);
        assertNotNull(ticket);
    }

}