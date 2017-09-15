package springcore.service.impl;

import org.springframework.stereotype.Service;
import springcore.dao.InMemmoryDataBaseSimulator;
import springcore.entity.User;
import springcore.service.UserService;

import java.util.List;



@Service
public class UserServiceImpl implements UserService {


    @Override
    public void save(User user) {
        InMemmoryDataBaseSimulator.getUsers().add(user);
    }

    @Override
    public void remove(User user) {
        InMemmoryDataBaseSimulator.getUsers().remove(user);
    }

    @Override
    public User getById(long id) {
        return InMemmoryDataBaseSimulator.getUsers().stream().filter(u -> u.getId() == id).findFirst().get();
    }

    @Override
    public User getUserByEmail(String email) {
        return InMemmoryDataBaseSimulator.getUsers().stream().filter(e -> e.getEmail().equals(email)).findFirst().get();
    }

    @Override
    public List<User> getAll() {
        return InMemmoryDataBaseSimulator.getUsers();
    }
}
