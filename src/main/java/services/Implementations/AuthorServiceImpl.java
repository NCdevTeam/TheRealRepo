package main.java.services.Implementations;

import main.java.DAO.AuthorsDAO;
import main.java.entities.Author;
import main.java.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by dR34m3r on 28.04.2017.
 */
@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorsDAO authorsDAO;

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
}
