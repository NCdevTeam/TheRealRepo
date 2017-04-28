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
@Transactional
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addUserRole(Role role) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void addUser(User user) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e ) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateUser(User user, Integer userId) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public User getUserById(Integer userId) throws SQLException{
        Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            user = (User) session.get(User.class,userId);
        } catch (Exception e ){

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public List<User> getAllUsers() throws SQLException{
        Session session = null;
        List users = new ArrayList<User>();
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("From User");
            users = query.list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public void deleteUser(User user) throws SQLException{
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }


}
