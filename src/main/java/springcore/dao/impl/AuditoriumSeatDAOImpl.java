package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import springcore.dao.AuditoriumDAO;
import springcore.dao.AuditoriumSeatDAO;
import springcore.dao.impl.mapper.AuditoriumSeatRowMapper;
import springcore.entity.Auditorium;
import springcore.entity.AuditoriumSeat;
import springcore.enums.TypeofSeat;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
        String sqlQuery = "select * from auditorium_seats where auditorium_id = ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{auditorium.getId()}, new AuditoriumSeatRowMapper(auditoriumDAO));
    }

    @Override
    public List<AuditoriumSeat> getByTypeOfSeat(TypeofSeat typeofSeat) {
        String sqlQuery = "select * from auditorium_seats where seat = ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{typeofSeat.name()}, new AuditoriumSeatRowMapper(auditoriumDAO));
    }

    @Override
    public AuditoriumSeat add(AuditoriumSeat auditoriumSeat) {
        String sqlQuery = "INSERT INTO auditorium_seats(number_of_seats, row, auditorium_id, seat) VALUES (?, ?, ?, ?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, auditoriumSeat.getNumberOfSeats());
            preparedStatement.setInt(2, auditoriumSeat.getRow());
            preparedStatement.setLong(3, auditoriumSeat.getAuditorium().getId());
            preparedStatement.setString(4, auditoriumSeat.getSeat().name());
            return preparedStatement;
        }, generatedKeyHolder);
        auditoriumSeat.setId(generatedKeyHolder.getKeyList().size() == 0 ? null : (Integer) generatedKeyHolder.getKeyList().get(0).get("id"));
        return auditoriumSeat;
    }

    @Override
    public AuditoriumSeat save(AuditoriumSeat auditoriumSeat) {
        String sqlquery = "update auditorium_seats set number = ?, seat_row = ?, auditorium_id = ?, seat_type = ? where id = ?";
        jdbcTemplate.update(sqlquery, auditoriumSeat.getNumberOfSeats(), auditoriumSeat.getRow(), auditoriumSeat.getAuditorium().getId(),
                auditoriumSeat.getSeat().ordinal());
        return auditoriumSeat;
    }

    @Override
    public AuditoriumSeat getById(int id) {
        String sqlquery = "select * from auditorium_seats where id = ?";
        List<AuditoriumSeat> auditoriumSeats = jdbcTemplate.query(sqlquery, new Object[]{id}, new AuditoriumSeatRowMapper(auditoriumDAO));
        return auditoriumSeats.size() > 0 ? auditoriumSeats.get(0) : null;
    }

    @Override
    public void delete(int id) {
        String sqlquery = "delete from auditorium_seats where id = ?";
        jdbcTemplate.update(sqlquery, id);
    }
}
