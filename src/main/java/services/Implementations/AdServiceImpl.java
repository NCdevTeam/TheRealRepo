package main.java.services.Implementations;

import main.java.DAO.AdsDAO;
import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;
import main.java.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 27.04.2017.
 */

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdsDAO adsDAO;

    public List<Ad> getAll() throws SQLException{
        return adsDAO.getAllAds();
    }
    public Ad getAd(Integer id) throws SQLException{
        return adsDAO.getAdById(id);
    }
    public List<Ad> getAdsByBook(Book book) throws SQLException{
        return adsDAO.getAdsByBook(book);
    }
    public List<Ad> getAdsByUser(User user) throws SQLException{
        return adsDAO.getAdsByUser(user);
    }
}
