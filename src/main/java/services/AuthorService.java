package main.java.services;

import main.java.entities.Author;

import java.sql.SQLException;

/**
 * Created by dR34m3r on 28.04.2017.
 */
public interface AuthorService {
    public Author getAuthorById(Integer authorId) throws SQLException;
}
