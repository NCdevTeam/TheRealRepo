package main.java.services.Implementations;

import main.java.DAO.AdsDAO;
import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;
import main.java.entities.Userbook;
import main.java.entities.enums.adStatus;
import main.java.entities.enums.userBookType;
import main.java.services.AdService;
import main.java.services.UserBookService;
import main.java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
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

    @Autowired
    private UserService userService;

    @Autowired
    private UserBookService userBookService;

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

    @Override
    public List<Ad> searchAdvertsByName(String searchString) {
        List<Ad> adList = null;
        try{
            adList=adsDAO.searchAdsByName(searchString);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            return adList;
        }
    }

    @Override
    public void bookBuy(Ad advert, Principal principal) {
        User seller = advert.getUser();
        User customer = userService.findUserByName(principal.getName());
        Book book = advert.getBook();
        Userbook link = userBookService.findLink(seller,book, userBookType.pool);
        link.setUser(customer);
        advert.setStatus(adStatus.inactive);
        try {
            adsDAO.updateAd(advert);
            userBookService.updateLink(link);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> getAdsByStatus(adStatus status) {
        List<Ad> adList=null;
        try{
            adList = adsDAO.getAllAdsByStatus(status);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            return adList;
        }
    }
}
