package main.java.DAO;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import main.java.entities.Book;
import main.java.entities.Author;

import java.util.Collection;
import java.sql.SQLException;
import java.util.List;

public interface BooksDAO {
    public void addBook(Book book) throws SQLException;
    public void updateBook(Book book) throws SQLException;
    public Book getBookById(Integer bookId) throws SQLException;
    public List<Book> getAllBooks() throws SQLException;
    public void deleteBook(Book book) throws SQLException;
    public List<Book> getBooksByAuthor(Author author) throws SQLException;
    public List<Book> searchLikeBookName(String likeString) throws SQLException;
}
