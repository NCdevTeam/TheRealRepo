package main.java.services.Implementations;

import main.java.DAO.MessagesDAO;
import main.java.entities.Message;
import main.java.entities.User;
import main.java.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
