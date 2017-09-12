package Service;

import Entity.User;

import java.util.LinkedList;
import java.util.List;

public interface UserService{


    void save(User user);

    void remove(User user);

    User getById(long id);

    User getUserByEmail(String email);

    List<User> getAll();
}
