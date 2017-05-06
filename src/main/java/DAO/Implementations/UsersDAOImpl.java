package main.java.DAO.Implementations;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.java.DAO.UsersDAO;
import main.java.entities.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.entities.User;

@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addUserRole(Role role) throws SQLException {
        sessionFactory.getCurrentSession().save(role);
    }

    public void addUser(User user) throws SQLException {
        sessionFactory.getCurrentSession().save(user);
    }

    public void updateUser(User user) throws SQLException {
        sessionFactory.getCurrentSession().update(user);
    }

    public User getUserById(Integer userId) throws SQLException{
        return (User) sessionFactory.getCurrentSession().get(User.class,userId);
    }

    public List<User> getAllUsers() throws SQLException{
        return sessionFactory.getCurrentSession().createQuery("From User").list();
    }

    public void deleteUser(User user) throws SQLException{
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User findUserByName(String name) throws SQLException {
        List<User> userList = sessionFactory.getCurrentSession().createQuery("From User where username = :parameterName")
                .setParameter("parameterName",name).list();
        if(userList.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return userList.get(0);
//                (User) sessionFactory.getCurrentSession()
//                .createSQLQuery("Select * from User where User.username = " + name).addEntity(User.class);
//        return (User)sessionFactory
//                .getCurrentSession()
//                .createQuery("From User where User.username = :parameterName")
//                .setParameter("parameterName",name);
    }
}
