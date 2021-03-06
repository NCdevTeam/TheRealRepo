package main.java.services;

import main.java.entities.Author;
import main.java.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import main.java.DAO.BooksDAO;

/**
 * Created by Владислав on 09.04.2017.
 */

public interface BookService {
    public List<Book> getAll();
    public Book getBook(Integer Id);
    public List<Book> getBooksByAuthor(Author author);
    public void createBook(Book book);
    public List<Book> searchLikeBookName(String searchString);
}
