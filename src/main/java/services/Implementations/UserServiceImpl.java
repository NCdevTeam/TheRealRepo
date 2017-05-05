package main.java.services.Implementations;

import main.java.DAO.UsersDAO;
import main.java.entities.Role;
import main.java.entities.User;
import main.java.entities.enums.userStatus;
import main.java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by dR34m3r on 28.04.2017.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersDAO usersDao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public void createUser(User user) {
        try {
            user.setStatus(userStatus.active);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role role = new Role();
            role.setUser(user);
            role.setRole("ROLE_USER");
            usersDao.addUser(user);
            usersDao.addUserRole(role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserByName(String name) {
        User user = null;
        try {
            user = usersDao.findUserByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return user;
        }
    }
}
