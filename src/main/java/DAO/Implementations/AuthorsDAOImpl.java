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
public class AuthorsDAOImpl implements AuthorsDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addAuthor(Author author) throws SQLException{
        sessionFactory.getCurrentSession().save(author);
        //test
        System.out.println(author.getId());
    }

    public void updateAuthor(Author author) throws SQLException{
        sessionFactory.getCurrentSession().update(author);
    }

    public Author getAuthorById(Integer authorId) throws SQLException{
        return (Author) sessionFactory.getCurrentSession().get(Author.class,authorId);
    }

    public void deleteAuthor(Author author) throws SQLException{
        sessionFactory.getCurrentSession().delete(author);
    }

    public List<Author> getAllAuthors() throws SQLException{
        return sessionFactory.getCurrentSession().createQuery("From Author").list();
    }

}
