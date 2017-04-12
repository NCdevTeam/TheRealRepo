package main.java.DAO.Implementations;

/**
 * Created by dR34m3r on 09.04.2017.
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import main.java.DAO.BooksDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.entities.Book;
import main.java.entities.Author;

@Repository
@Transactional
public class BooksDAOImpl implements BooksDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addBook(Book book) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateBook(Book book,Integer bookId) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Book getBookById(Integer bookId) throws SQLException {
        Session session = null;
        Book book = null;
        try {
            session = sessionFactory.openSession();
            book = (Book) session.get(Book.class,bookId);
        } catch (Exception e ){

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return book;
    }

    public Collection getAllBooks() throws SQLException {
        Session session = null;
        List books = new ArrayList<Book>();
        try {
            session = sessionFactory.openSession();
            books = session.createSQLQuery("Select * from books").list();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return books;
    }

    public void deleteBook(Book book) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getBooksByAuthor(Author author) throws SQLException {
        Session session = null;
        List books = new ArrayList<Book>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            books = session.createSQLQuery("select * from books where books.authorID = " + author.getId()).list();
            session.getTransaction().commit();

        } catch (Exception e ) {

        } finally {
            if( session != null && session.isOpen()) {
                session.close();
            }
        }
        return books;
    }
}
