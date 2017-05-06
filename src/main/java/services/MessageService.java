package main.java.services;

import main.java.entities.Message;
import main.java.entities.User;

import java.util.List;

/**
 * Created by dR34m3r on 05.05.2017.
 */
public interface MessageService {
    public List<Message> getDialog(User sender, User receiver);
    public List<Message> getUserMessageList(User user);
    public void addMessage(Message message);
}
