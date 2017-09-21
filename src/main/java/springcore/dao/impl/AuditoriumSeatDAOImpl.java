package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import springcore.dao.AuditoriumDAO;
import springcore.dao.AuditoriumSeatDAO;
import springcore.dao.impl.mapper.AuditoriumSeatRowMapper;
import springcore.entity.Auditorium;
import springcore.entity.AuditoriumSeat;
import springcore.enums.TypeofSeat;

import java.util.List;


@Component
public class AuditoriumSeatDAOImpl implements AuditoriumSeatDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    @Override
    public List<AuditoriumSeat> getAll() {
        String sqlQuery = "select * from auditorium_seats";
        return jdbcTemplate.query(sqlQuery, new AuditoriumSeatRowMapper(auditoriumDAO));
    }

    @Override
    public List<AuditoriumSeat> getByAuditorium(Auditorium auditorium) {
        return null;
    }

    @Override
    public List<AuditoriumSeat> getByTypeOfSeat(TypeofSeat typeofSeat) {
        return null;
    }

    @Override
    public AuditoriumSeat add(AuditoriumSeat auditoriumSeat) {
        return null;
    }

    @Override
    public AuditoriumSeat save(AuditoriumSeat auditoriumSeat) {
        return null;
    }

    @Override
    public AuditoriumSeat getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
