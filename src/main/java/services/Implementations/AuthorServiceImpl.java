package main.java.services.Implementations;

import main.java.DAO.AuthorsDAO;
import main.java.entities.Author;
import main.java.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 28.04.2017.
 */
@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorsDAO authorsDAO;

    @Override
    public Author getAuthorById(Integer authorId)  {
        Author author = null;
        try {
            author = authorsDAO.getAuthorById(authorId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return author;
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authorList = null;
        try {
            authorList = authorsDAO.getAllAuthors();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return authorList;
        }
    }

    @Override
    public void createNewAuthor(Author author) {
        try {
            authorsDAO.addAuthor(author);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
