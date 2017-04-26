package main.java.DAO;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import main.java.entities.User;

import java.util.Collection;
import java.sql.SQLException;
import java.util.List;


public interface UsersDAO {
    public void addUser(User user) throws SQLException;
    public void updateUser(User user, Integer userId) throws SQLException;
    public User getUserById(Integer userId) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    public void deleteUser(User user) throws SQLException;
}
