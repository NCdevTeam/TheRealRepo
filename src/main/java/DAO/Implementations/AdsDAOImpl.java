package main.java.DAO.Implementations;

/**
 * Created by dR34m3r on 08.04.2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.java.DAO.AdsDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.User;

@Repository
@Transactional
public class AdsDAOImpl implements AdsDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addAd(Ad advert) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(advert);
            session.getTransaction().commit();
        } catch (Exception e ) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateAd(Ad advert, Integer adId) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(advert);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Ad getAdById(Integer adId) throws SQLException {
        Session session = null;
        Ad advert = null;
        try {
            session = sessionFactory.openSession();
            advert = (Ad) session.get(Ad.class,adId);
        } catch (Exception e ){

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return advert;
    }

    public Collection getAllAds() throws SQLException {
        Session session = null;
        List ads = new ArrayList<Ad>();
        try {
            session = sessionFactory.openSession();
            ads = session.createSQLQuery("select * from ads").list();
        } catch (Exception e ) {

        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ads;
    }

    public void deleteAd(Ad advert) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(advert);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAdsByUser(User user) throws SQLException {
        Session session = null;
        List ads = new ArrayList<Ad>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            ads = session.createSQLQuery("select * from ads where ads.userID = " + user.getId()).list();
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ads;
    }

    public Collection getAdsByBook(Book book) throws SQLException {
        Session session = null;
        List ads = new ArrayList<Ad>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            ads = session.createSQLQuery("Select * from ads where ads.bookID = " + book.getId()).list();
            session.getTransaction().commit();
        } catch (Exception e ) {} finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ads;
    }
}
