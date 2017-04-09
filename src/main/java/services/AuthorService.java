package main.java.services;

/**
 * Created by dR34m3r on 09.04.2017.
 */

import main.java.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import main.java.util.interfaces.AuthorDAO;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    public Author getAuthorById(Integer authorId) throws SQLException {
        return authorDAO.getAuthorById(authorId);
    }
}
