package main.java.DAO.Implementations;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.DAO.AuthorsDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.entities.Author;

@Repository
@Transactional
public class AuthorsDAOImpl implements AuthorsDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addAuthor(Author author) throws SQLException{
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        } catch (Exception e ) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateAuthor(Author author) throws SQLException{
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(author);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Author getAuthorById(Integer authorId) throws SQLException{
        Session session = null;
        Author author = null;
        try {
            session = sessionFactory.openSession();
            author = (Author) session.get(Author.class,authorId);
        } catch (Exception e ){

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return author;
    }

    public void deleteAuthor(Author author) throws SQLException{
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(author);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Author> getAllAuthors() throws SQLException{
        Session session = null;
        List authors = new ArrayList<Author>();
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("From Author ");
            authors = query.list();
        } catch (Exception e ){

        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return authors;
    }

}
