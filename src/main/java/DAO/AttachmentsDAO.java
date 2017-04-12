package main.java.util.interfaces;

import main.java.pojo.Ad;
import main.java.pojo.Attachment;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dR34m3r on 09.04.2017.
 */
public interface AttachmentsDAO {

    public void addAttachment(Attachment attachment) throws SQLException;
    public void updateAttachment(Attachment attachment,Integer attachmentId) throws SQLException;
    public Attachment getAttachmentById(Integer attachmentId) throws SQLException;
    public Collection getAttachmentsByAd(Ad advert) throws SQLException;
    public void deleteAttachment(Attachment attachment) throws SQLException;

}