package main.java.DAO;

import main.java.entities.Book;
import main.java.entities.User;
import main.java.entities.Userbook;
import main.java.entities.enums.userBookType;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 06.05.2017.
 */
public interface UserbooksDAO {
    public void addUserBookLink(Userbook userbook) throws SQLException;
    public void deleteUserBookLink(Userbook userbook) throws SQLException;
    public List<Userbook> findUserBookLinksByType(User user,userBookType type) throws SQLException;
    public Userbook selectLink(Userbook buildedLink) throws SQLException;
    public Userbook findLink(User user, Book book, userBookType type) throws SQLException;
    public void updateLink(Userbook link) throws SQLException;
}
