package main.java.DAO.Implementations;

import main.java.DAO.MessagesDAO;
import main.java.entities.Message;
import main.java.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 05.05.2017.
 */
@Repository
public class MessagesDAOImpl implements MessagesDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Message> getDialog(User sender, User receiver) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Message as m " +
                        "where (m.sender = :parameterSender and m.receiver = :parameterReceiver)" +
                        "or (m.sender = :parameterReceiver and m.receiver = :parameterSender) " +
                        "order by m.msgDateTime")
                .setParameter("parameterSender",sender)
                .setParameter("parameterReceiver",receiver)
                .list();
    }

    @Override
    public List<Message> getUserMessageList(User user) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Message as m where m.receiver = :parameterUser or m.sender = :parameterUser")
                .setParameter("parameterUser",user)
                .list();
    }

    @Override
    public void addMessage(Message message) throws SQLException {
        sessionFactory.getCurrentSession().save(message);
    }

    @Override
    public List<User> getListOfInterlocutors(User user) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createSQLQuery(
                             "Select `user`.* " +
                                "From messages " +
                                "join `user` on `user`.ID = messages.whomUserId " +
                                "where fromUserId = " + user.getId() +
                                " union " +
                                     "select `user`.* " +
                                     "From messages " +
                                     "join `user` on `user`.ID = messages.fromUserId " +
                                     "where whomUserId = " + user.getId()
                )
                .addEntity(User.class)
                .list();
    }
}
