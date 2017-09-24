package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import springcore.dao.AuditoriumDAO;
import springcore.dao.impl.mapper.AuditoriumRowMapper;
import springcore.entity.Auditorium;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Component
public class AuditoriumDAOImpl implements AuditoriumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuditoriumRowMapper auditoriumRowMapper;


    @Override
    public List<Auditorium> getAll() {
        String sqlQuery = "select * from auditoriums";
        return jdbcTemplate.query(sqlQuery, auditoriumRowMapper);
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
        jdbcTemplate.update(con->{
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, auditorium.getName());
            return preparedStatement;
        }, generatedKeyHolder);

        Optional<List<Map<String, Object>>> keyList = Optional.ofNullable(generatedKeyHolder.getKeyList());
        Object id = keyList.map(k->k.iterator().next()).map(n->n.get("id")).orElse(null);
        auditorium.setId((long) id);
        return auditorium;
    }

    @Override
    public Auditorium getById(int id) {
        String sqlquery = "select * from auditoriums where id = ?";
        List<Auditorium> auditoriums = jdbcTemplate.query(sqlquery, new Object[]{id}, auditoriumRowMapper);
        return auditoriums.size() > 0 ? auditoriums.get(0) : null;
    }


    @Override
    public void delete(int id) {
        String sqlQuery = "delete from auditoriums where id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }
}
