package main.java.DAO;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;

import java.util.Collection;
import java.sql.SQLException;
import java.util.List;

public interface AdsDAO {
    public void addAd(Ad advert) throws SQLException;
    public void updateAd(Ad advert,Integer adId) throws SQLException;
    public Ad getAdById(Integer adId) throws SQLException;
    public List<Ad> getAllAds() throws SQLException;
    public void deleteAd(Ad advert) throws SQLException;
    public List<Ad> getAdsByUserId(Integer userId) throws SQLException;
    public List<Ad> getAdsByBookId(Integer bookId) throws SQLException;
}
