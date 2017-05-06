package main.java.DAO;

import main.java.entities.Message;
import main.java.entities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 05.05.2017.
 */
public interface MessagesDAO {
    public void addMessage(Message message) throws SQLException;
    public List<Message> getUserMessageList(User user) throws SQLException;
    public List<Message> getDialog(User sender, User receiver) throws SQLException;
}
