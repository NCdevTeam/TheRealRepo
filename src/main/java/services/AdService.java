package main.java.services;


import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;
import main.java.entities.enums.adStatus;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

public interface AdService {
    public List<Ad> getAll();
    public Ad getAd(Integer id);
    public List<Ad> getAdsByBook(Book book);
    public List<Ad> getAdsByUser(User user);
    public void createAdvert(Ad advert);
    public List<Ad> searchAdvertsByName(String searchString);
    public void bookBuy(Ad advert, Principal principal);
    public List<Ad> getAdsByStatus(adStatus status);
}
