package main.java.services.Implementations;

import main.java.DAO.BooksDAO;
import main.java.entities.Author;
import main.java.entities.Book;
import main.java.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 26.04.2017.
 */
@Transactional
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BooksDAO booksDAO;

    public List<Book> getAll() throws SQLException {
        return booksDAO.getAllBooks();
    }

    public Book getBook(Integer Id) throws SQLException{
        return booksDAO.getBookById(Id);
    }

    public List<Book> getBooksByAuthor(Author author) throws SQLException{
        return booksDAO.getBooksByAuthor(author);
    }
}
