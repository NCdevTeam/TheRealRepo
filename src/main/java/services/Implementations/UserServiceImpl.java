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
    UsersDAO dao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public void createUser(User user) throws SQLException {
        user.setStatus(userStatus.active);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role();
        role.setUser(user);
        role.setRole("ROLE_USER");
        dao.addUser(user);
        dao.addUserRole(role);
    }
}
