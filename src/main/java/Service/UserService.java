package Service;

import Entity.User;

import java.util.LinkedList;
import java.util.List;

public class UserService implements Service<User> {

    private List<User> users;

    public UserService() {
        users = new LinkedList<>();
    }


    public void save(User user) {
        users.add(user);
    }


    public void remove(User user) {
        users.remove(user);
    }


    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getByName(String name) {
        for (User user : users) {
            if (name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }

    @Override
    public User getById(int id) {
        for (User user : users) {
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }
}
