package springcore.dao.impl.mapper;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import springcore.entity.Auditorium;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuditoriumRowMapper implements RowMapper<Auditorium>{



    @Override
    public Auditorium mapRow(ResultSet rs, int rowNum) throws SQLException {
        Auditorium auditorium = new Auditorium();
        auditorium.setId(rs.getInt("id"));
        auditorium.setName(rs.getString("name"));
        return auditorium;
    }
}
