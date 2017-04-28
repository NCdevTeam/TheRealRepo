package main.java.services;


import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface AdService {
    public List<Ad> getAll() throws SQLException;
    public Ad getAd(Integer id) throws SQLException;
    public List<Ad> getAdsByBook(Book book) throws SQLException;
    public List<Ad> getAdsByUser(User user) throws SQLException;
}
