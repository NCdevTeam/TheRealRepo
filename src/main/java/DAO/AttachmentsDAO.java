package main.java.DAO;

import main.java.entities.Ad;
import main.java.entities.Attachment;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by dR34m3r on 09.04.2017.
 */
public interface AttachmentsDAO {

    public void addAttachment(Attachment attachment) throws SQLException;
    public void updateAttachment(Attachment attachment,Integer attachmentId) throws SQLException;
    public Attachment getAttachmentById(Integer attachmentId) throws SQLException;
    public List<Attachment> getAttachmentsByAdId(Integer AdId) throws SQLException;
    public void deleteAttachment(Attachment attachment) throws SQLException;

}
