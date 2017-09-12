package Service.impl;

import DAO.InMemmoryDataBaseSimulator;
import Entity.User;
import Service.UserService;

import java.util.List;

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
