package springcore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import springcore.dao.UserDAO;
import springcore.dao.impl.mapper.UserRowMapper;
import springcore.entity.User;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Component
public class UserDAOImpl implements UserDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRowMapper userRowMapper;


    @Override
    public User refresh(User user) {
        String sqlQuery = "UPDATE users SET firstname = ?, lastname = ?, email = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getId());
        return user;
    }

    @Override
    public User add(User user) {
        String sqlQuery = "insert into users(firstname, lastname, email, password) values(?,?,?,?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            return preparedStatement;
        }, generatedKeyHolder);
        Optional<List<Map<String, Object>>> keyList = Optional.ofNullable(generatedKeyHolder.getKeyList());
        Object id = keyList.map(i->i.iterator().next()).map(n->n.get("id")).orElse(null);
        user.setId((long) id);
        return user;
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "delete from users where id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public User getById(int id) {
        String sqlQuery = "select from users where id = ?";
        List<User> users = jdbcTemplate.query(sqlQuery, new Object[]{id}, userRowMapper);
        return users.size()> 0 ? users.get(0) : null;
    }

    @Override
    public User getUserByEmail(String email) {
        String sqlQuery = "select * from users where email = ?";
        List<User> users = jdbcTemplate.query(sqlQuery, new Object[]{email}, userRowMapper);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public List<User> getAll() {
        String sqlQuery = "select * from users";
        return jdbcTemplate.query(sqlQuery, userRowMapper);
    }
}
