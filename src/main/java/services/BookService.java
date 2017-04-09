package main.java.services;

import main.java.DAO.BooksDAOImpl;
import main.java.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import main.java.util.interfaces.BooksDAO;

/**
 * Created by Владислав on 09.04.2017.
 */

@Service
@Transactional
public class BookService {

    @Autowired
    private BooksDAO booksDAO;

    public Collection getAll() throws  SQLException{
        return booksDAO.getAllBooks();
    }

    public Book getBook(Integer Id) throws SQLException{
        return booksDAO.getBookById(Id);
    }
}
