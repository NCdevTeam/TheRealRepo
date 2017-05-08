package main.java.services.Implementations;

import main.java.DAO.AdsDAO;
import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;
import main.java.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 27.04.2017.
 */

@Transactional
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdsDAO adsDAO;

    public List<Ad> getAll(){
        List<Ad> adList = null;
        try {
            adList = adsDAO.getAllAds();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return adList;
        }
    }
    public Ad getAd(Integer id){
        Ad ad = null;
        try {
            ad = adsDAO.getAdById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return ad;
        }
    }
    public List<Ad> getAdsByBook(Book book){
        List<Ad> adList = null;
        try {
            adList = adsDAO.getAdsByBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return adList;
        }
    }
    public List<Ad> getAdsByUser(User user) {
        List<Ad> adList = null;
        try {
            adList = adsDAO.getAdsByUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return adList;
        }
    }

    @Override
    public void createAdvert(Ad advert) {
        try{
            adsDAO.addAd(advert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
