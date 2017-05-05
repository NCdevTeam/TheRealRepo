package main.java.services;

import main.java.entities.User;

import java.sql.SQLException;

/**
 * Created by dR34m3r on 28.04.2017.
 */
public interface UserService {
    public void createUser(User user);
    public User findUserByName(String name);
}
