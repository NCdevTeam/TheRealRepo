package main.java.DAO.Implementations;

import main.java.DAO.UserbooksDAO;
import main.java.entities.Book;
import main.java.entities.User;
import main.java.entities.Userbook;
import main.java.entities.enums.userBookType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 06.05.2017.
 */
@Repository
public class UserbooksDAOImpl implements UserbooksDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUserBookLink(Userbook userbook) throws SQLException {
        sessionFactory.getCurrentSession().save(userbook);
    }

    @Override
    public void deleteUserBookLink(Userbook userbook) throws SQLException {
        sessionFactory.getCurrentSession().delete(userbook);
    }

    @Override
    public List<Userbook> findUserBookLinksByType(User user, userBookType type) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Userbook as ub where ub.user = :parameterUser and ub.type = :parameterType")
                .setParameter("parameterUser",user)
                .setParameter("parameterType",type)
                .list();
    }

    @Override
    public Userbook selectLink(Userbook buildedLink) throws SQLException {
        List<Userbook> temp;
        temp = sessionFactory
                .getCurrentSession()
                .createQuery("From Userbook as ub where ub.user= :parameterUser and ub.book = :parameterBook and ub.type = :parameterType")
                .setParameter("parameterUser",buildedLink.getUser())
                .setParameter("parameterBook",buildedLink.getBook())
                .setParameter("parameterType",buildedLink.getType())
                .list();
        if(temp.isEmpty()) {
            return null;
        }
        return temp.get(0);

    }

    @Override
    public Userbook findLink(User user, Book book, userBookType type) throws SQLException {
        List<Userbook> userbookList = sessionFactory.getCurrentSession()
                .createQuery("From Userbook as ub where ub.user = :parUser and ub.book = :parBook and ub.type = :parType")
                .setParameter("parUser",user)
                .setParameter("parBook",book)
                .setParameter("parType",type)
                .list();
        return userbookList.get(0);
    }

    @Override
    public void updateLink(Userbook link) throws SQLException {
        sessionFactory.getCurrentSession().update(link);
    }
}
