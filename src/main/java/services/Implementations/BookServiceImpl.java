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

    public List<Book> getAll() {
        List<Book> bookList = null;
        try {
            bookList = booksDAO.getAllBooks();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return bookList;
        }
    }

    public Book getBook(Integer Id) {
        Book book = null;
        try {
            book = booksDAO.getBookById(Id);
        } catch (SQLException e ){
            e.printStackTrace();
        } finally {
            return book;
        }
    }

    public List<Book> getBooksByAuthor(Author author) {
        List<Book> bookList = null;
        try {
            bookList = booksDAO.getBooksByAuthor(author);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return bookList;
        }
    }

    @Override
    public void createBook(Book book) {
        try{
            booksDAO.addBook(book);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> searchLikeBookName(String searchString) {
        List<Book> bookList=null;
        try{
            bookList = booksDAO.searchLikeBookName(searchString);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return bookList;
        }
    }
}
