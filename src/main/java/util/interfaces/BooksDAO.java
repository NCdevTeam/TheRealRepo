package main.java.util.interfaces;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import main.java.pojo.Book;
import main.java.pojo.Author;

import java.util.Collection;
import java.sql.SQLException;

public interface BooksDAO {
    public void addBook(Book book) throws SQLException;
    public void updateBook(Book book, Integer bookId) throws SQLException;
    public Book getBookById(Integer bookId) throws SQLException;
    public Collection getAllBooks() throws SQLException;
    public void deleteBook(Book book) throws SQLException;
    public Collection getBooksByAuthor(Author author) throws SQLException;
}
