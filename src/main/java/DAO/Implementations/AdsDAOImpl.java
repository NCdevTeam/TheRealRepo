package main.java.DAO.Implementations;

/**
 * Created by dR34m3r on 08.04.2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.java.DAO.AdsDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;

@Repository
public class AdsDAOImpl implements AdsDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addAd(Ad advert) throws SQLException {
        sessionFactory.getCurrentSession().save(advert);
    }

    public void updateAd(Ad advert) throws SQLException {
        sessionFactory.getCurrentSession().update(advert);
    }

    public Ad getAdById(Integer adId) throws SQLException {
        return (Ad) sessionFactory.getCurrentSession().get(Ad.class,adId);
    }

    public List<Ad> getAllAds() throws SQLException {
        return sessionFactory.getCurrentSession().createQuery("From Ad").list();
    }

    public void deleteAd(Ad advert) throws SQLException {
        sessionFactory.getCurrentSession().delete(advert);
    }

    public List<Ad> getAdsByUser(User user) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Ad as advert where advert.user = :parameterId")
                .setParameter("parameterId",user)
                .list();
    }

    public List<Ad> getAdsByBook(Book book) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Ad as advert where advert.book = :parameterId")
                .setParameter("parameterId",book)
                .list();
    }

    @Override
    public List<Ad> searchAdsByName(String searchString) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Ad as advert where advert.advertName like :searchString")
                .setParameter("searchString","%"+searchString+"%")
                .list();
    }
}
