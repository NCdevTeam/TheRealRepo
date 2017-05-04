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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AttachmentsDAOImpl implements AttachmentsDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addAttachment(Attachment attachment) throws SQLException {
        sessionFactory.getCurrentSession().save(attachment);
    }

    public void updateAttachment(Attachment attachment) throws SQLException {
        sessionFactory.getCurrentSession().update(attachment);
    }

    public Attachment getAttachmentById(Integer attachmentId) throws SQLException {
        return (Attachment) sessionFactory.getCurrentSession().get(Attachment.class,attachmentId);
    }

    public List<Attachment> getAttachmentsByAd(Ad ad) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Attachment as at where at.ad = :parameterId")
                .setParameter("parameterId",ad)
                .list();
    }

    public void deleteAttachment(Attachment attachment) throws SQLException {
        sessionFactory.getCurrentSession().delete(attachment);
    }

}
