package main.java.DAO;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import main.java.entities.Author;

import java.util.Collection;
import java.sql.SQLException;
import java.util.List;

public interface AuthorsDAO {
    public void addAuthor(Author author) throws SQLException;
    public void updateAuthor(Author author) throws SQLException;
    public Author getAuthorById(Integer authorId) throws SQLException;
    public void deleteAuthor(Author author) throws SQLException;
    public List<Author> getAllAuthors() throws SQLException;
}
