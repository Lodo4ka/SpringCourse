package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import springcore.dao.AuditoriumDAO;
import springcore.dao.simulator.InMemmoryDataBaseSimulator;
import springcore.dao.impl.mapper.AuditoriumRowMapper;
import springcore.entity.Auditorium;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


@Component
public class AuditoriumDAOImpl implements AuditoriumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Auditorium> getAll() {
        String sqlQuery = "select * from auditoriums";
        return jdbcTemplate.query(sqlQuery, new AuditoriumRowMapper());
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        String sqlQuery = "update auditoriums set name = ? where id = ?";
        jdbcTemplate.update(sqlQuery, auditorium.getName());
        return auditorium;
    }

    @Override
    public Auditorium add(Auditorium auditorium) {
        String sqlQuery = "insert into auditoriums(name) values(?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, auditorium.getName());
            return preparedStatement;
        }, generatedKeyHolder);
        auditorium.setId(generatedKeyHolder.getKeyList().size() == 0 ? null : (Integer) generatedKeyHolder.getKeyList().get(0).get("id"));
        return auditorium;
    }

    @Override
    public Auditorium getById(int id) {
        String sqlquery = "select * from auditoriums where id = ?";
        List<Auditorium> auditoriums = jdbcTemplate.query(sqlquery, new Object[]{id}, new AuditoriumRowMapper());
        return auditoriums.size() > 0 ? auditoriums.get(0) : null;
    }


    @Override
    public void delete(int id) {
        String sqlQuery = "delete from auditoriums where id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }
}
