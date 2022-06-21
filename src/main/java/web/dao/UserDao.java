package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void removeUser(int id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUser(int id);
}
