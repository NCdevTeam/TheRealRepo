package main.java.services.Implementations;

import main.java.DAO.MessagesDAO;
import main.java.entities.Message;
import main.java.entities.User;
import main.java.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.cs.ISO_8859_2;
import sun.nio.cs.UTF_32;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by dR34m3r on 05.05.2017.
 */
@Transactional
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessagesDAO msgDao;

    @Override
    public void addMessage(Message message) {
        try {
            message.setMsgDateTime(new Date());
//            byte[] ptext = message.getText().getBytes(Charset.forName("ISO-8859-1"));
//            message.setText(new String(ptext, Charset.forName("UTF-8")));
            msgDao.addMessage(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Message> getUserMessageList(User user) {
        List<Message> messageList = null;
        try {
            messageList = msgDao.getUserMessageList(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return messageList;
        }
    }

    @Override
    public List<Message> getDialog(User sender, User receiver) {
        List<Message> messageList = null;
        try {
            messageList = msgDao.getDialog(sender,receiver);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return messageList;
        }
    }

    @Override
    public List<User> getListOfInterlocutors(User user) {
        List<User> userList = null;
        try {
            userList = msgDao.getListOfInterlocutors(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return userList;
        }
    }
}
