package main.java.DAO.Implementations;

/**
 * Created by dR34m3r on 09.04.2017.
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import main.java.DAO.BooksDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.entities.Book;
import main.java.entities.Author;

@Repository
public class BooksDAOImpl implements BooksDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addBook(Book book) throws SQLException {
        sessionFactory.getCurrentSession().save(book);
        //test
        System.out.println(book.getId());
    }

    public void updateBook(Book book) throws SQLException {
        sessionFactory.getCurrentSession().update(book);
    }

    public Book getBookById(Integer bookId) throws SQLException {
        return (Book) sessionFactory.getCurrentSession().get(Book.class,bookId);
    }

    public List<Book> getAllBooks() throws SQLException {
        return sessionFactory.getCurrentSession().createQuery("From Book").list();
    }

    public void deleteBook(Book book) throws SQLException {
        sessionFactory.getCurrentSession().delete(book);
    }

    public List<Book> getBooksByAuthor(Author author) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Book as bk where bk.author = :parameterId")
                .setParameter("parameterId",author)
                .list();
    }

    @Override
    public List<Book> searchLikeBookName(String likeString) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Book as bk where bk.name like :param")
                .setParameter("param","%"+likeString+"%")
                .list();
    }
}
