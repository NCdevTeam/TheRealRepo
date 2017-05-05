package main.java.DAO.Implementations;

import main.java.DAO.CommentsDAO;
import main.java.entities.Comment;
import main.java.entities.User;
import main.java.entities.enums.noteType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 09.04.2017.
 */

@Repository
public class CommentsDAOImpl implements CommentsDAO {

    @Autowired SessionFactory sessionFactory;

    public Comment getCommentById(Integer commentId) throws SQLException {
        return (Comment)sessionFactory.getCurrentSession().get(Comment.class,commentId);
    }

    public List<Comment> getCommentsByUser(User user) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Comment where Comment.user = :parameterId")
                .setParameter("parameterId",user)
                .list();
    }

    public List<Comment> getCommentsByNote(Integer noteId, noteType type) throws SQLException {
        return sessionFactory
                .getCurrentSession()
                .createQuery("From Comment as c where c.noteId = noteId and c.noteType = noteType")
                .list();
    }

    @Override
    public void addComment(Comment comment) throws SQLException {
        sessionFactory.getCurrentSession().save(comment);
    }
}
