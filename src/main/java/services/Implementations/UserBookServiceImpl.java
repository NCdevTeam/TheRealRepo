package main.java.services.Implementations;

import main.java.DAO.BooksDAO;
import main.java.DAO.UserbooksDAO;
import main.java.DAO.UsersDAO;
import main.java.entities.Book;
import main.java.entities.User;
import main.java.entities.Userbook;
import main.java.entities.enums.userBookType;
import main.java.services.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 06.05.2017.
 */
@Transactional
@Service
public class UserBookServiceImpl implements UserBookService {

    @Autowired UserbooksDAO userBooksDAO;
    @Autowired UsersDAO usersDAO;
    @Autowired BooksDAO booksDAO;

    private Userbook buildBook(String username,Integer bookId, userBookType linkType) {
        Userbook result = null;
        try {
            Userbook temp = new Userbook();
            temp.setBook(booksDAO.getBookById(bookId));
            temp.setUser(usersDAO.findUserByName(username));
            temp.setType(linkType);
            result = temp;
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @Override
    public void addLink(String username, Integer bookId, userBookType linkType) {
        Userbook userbook = buildBook(username,bookId,linkType);
        try {
            userBooksDAO.addUserBookLink(userbook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLink(String username,Integer bookId, userBookType linkType) {
        Userbook userbook = buildBook(username,bookId,linkType);
        try {
            userbook = userBooksDAO.selectLink(userbook);
            userBooksDAO.deleteUserBookLink(userbook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Userbook> findUserLinksByType(User user, userBookType linkType) {
        List<Userbook> userbookList = null;
        try {
            userbookList = userBooksDAO.findUserBookLinksByType(user,linkType);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return userbookList;
        }
    }

    @Override
    public Boolean isLinked(String username, Integer bookId, userBookType linkType) {
        Boolean result = false;
        try{
            if(userBooksDAO.selectLink(buildBook(username,bookId,linkType)) != null) {
                result = true;
            } else {
                result = false;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
//        List<Userbook> userbookList = findUserLinksByType(user,linkType);
//        if(userbookList.isEmpty()) {
//            return false;
//        }
//        for(Userbook link : userbookList) {
//            if(link.getBook().equals(book)) {
//                return true;
//            }
//        }
//        return false;
    }
}
