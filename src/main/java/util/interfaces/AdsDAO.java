package main.java.util.interfaces;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import main.java.pojo.Ad;
import main.java.pojo.Book;
import main.java.pojo.User;

import java.util.Collection;
import java.sql.SQLException;

public interface AdsDAO {
    public void addAd(Ad advert) throws SQLException;
    public void updateAd(Ad advert,Integer adId) throws SQLException;
    public Ad getAdById(Integer adId) throws SQLException;
    public Collection getAllAds() throws SQLException;
    public void deleteAd(Ad advert) throws SQLException;
    public Collection getAdsByUser(User user) throws SQLException;
    public Collection getAdsByBook(Book book) throws SQLException;
}
