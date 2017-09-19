package springcore.dao;

import springcore.entity.User;

public interface UserDAO {

    User create(User user);

    User read(User user);

    void update(User user);

    void delete(User user);
}
