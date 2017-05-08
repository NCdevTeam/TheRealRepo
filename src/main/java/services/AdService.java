package main.java.services;


import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface AdService {
    public List<Ad> getAll();
    public Ad getAd(Integer id);
    public List<Ad> getAdsByBook(Book book);
    public List<Ad> getAdsByUser(User user);
    public void createAdvert(Ad advert);
}
