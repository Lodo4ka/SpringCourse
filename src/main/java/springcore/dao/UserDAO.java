package springcore.dao;

import springcore.entity.User;

import java.util.List;

public interface UserDAO {

    User save(User user);

    User add(User user);

    void delete(int id);

    User getById(int id);

    User getUserByEmail(String email);

    List<User> getAll();
}
