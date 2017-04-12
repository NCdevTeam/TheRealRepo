package main.java.DAO.Implementations;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.java.DAO.AttachmentsDAO;
import main.java.entities.Attachment;
import main.java.entities.Ad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AttachmentsDAOImpl implements AttachmentsDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addAttachment(Attachment attachment) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(attachment);
            session.getTransaction().commit();
        } catch (Exception e ) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateAttachment(Attachment attachment,Integer attachmentId) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(attachment);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Attachment getAttachmentById(Integer attachmentId) throws SQLException {
        Session session = null;
        Attachment attachment = null;
        try {
            session = sessionFactory.openSession();
            attachment = (Attachment) session.get(Attachment.class,attachmentId);
        } catch (Exception e ){

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return attachment;
    }

    public Collection getAttachmentsByAd(Ad advert) throws SQLException {
        Session session = null;
        List attachments = new ArrayList<Attachment>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            attachments = session.createSQLQuery("Select * from attachments where attachments.adsID = "
                                                    + advert.getId()).list();
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return attachments;
    }

    public void deleteAttachment(Attachment attachment) throws SQLException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(attachment);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
