package springcore.dao.impl.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import springcore.dao.AuditoriumDAO;
import springcore.dao.AuditoriumSeatDAO;
import springcore.entity.AuditoriumSeat;
import springcore.enums.TypeofSeat;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuditoriumSeatRowMapper implements RowMapper<AuditoriumSeat> {


    AuditoriumDAO auditoriumDAO;

    public AuditoriumSeatRowMapper(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    @Override
    public AuditoriumSeat mapRow(ResultSet rs, int rowNum) throws SQLException {
        AuditoriumSeat auditoriumSeat = new AuditoriumSeat();
        auditoriumSeat.setId(rs.getInt("id"));
        auditoriumSeat.setAuditorium(auditoriumDAO.getById(rs.getInt("auditorium_id")));
        auditoriumSeat.setNumberOfSeats(rs.getInt("number_of_seats"));
        auditoriumSeat.setRow(rs.getInt("row"));
        auditoriumSeat.setSeat(TypeofSeat.valueOf(rs.getString("seat")));
        return auditoriumSeat;
    }
}
