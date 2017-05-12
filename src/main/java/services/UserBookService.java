package main.java.services;

import main.java.entities.Book;
import main.java.entities.User;
import main.java.entities.Userbook;
import main.java.entities.enums.userBookType;

import java.util.List;

/**
 * Created by dR34m3r on 06.05.2017.
 */
public interface UserBookService {
    public void addLink(String username, Integer bookId, userBookType type);
    public void deleteLink(String username, Integer bookId, userBookType type);
    public List<Userbook> findUserLinksByType(User user, userBookType type);
    public Boolean isLinked(String username, Integer bookId, userBookType linkType);
    public Userbook findLink(User user, Book book, userBookType type);
    public void updateLink(Userbook link);
}
