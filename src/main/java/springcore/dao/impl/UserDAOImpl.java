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


@Component
public class UserDAOImpl implements UserDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;


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
        user.setId(generatedKeyHolder.getKeyList().size() == 0 ? null : (Integer)generatedKeyHolder.getKeyList().get(0).get("id"));
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
        List<User> users = jdbcTemplate.query(sqlQuery, new Object[]{id}, new UserRowMapper());
        return users.size()> 0 ? users.get(0) : null;
    }

    @Override
    public User getUserByEmail(String email) {
        String sqlQuery = "select * from users where email = ?";
        List<User> users = jdbcTemplate.query(sqlQuery, new Object[]{email}, new UserRowMapper());
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public List<User> getAll() {
        String sqlQuery = "select * from users";
        return jdbcTemplate.query(sqlQuery, new UserRowMapper());
    }
}
