package main.java.DAO;

import main.java.entities.Comment;
import main.java.entities.User;
import main.java.entities.enums.noteType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dR34m3r on 09.04.2017.
 */
public interface CommentsDAO {
    public void addComment(Comment comment) throws SQLException;
    public Comment getCommentById(Integer commentId) throws SQLException;
    public List<Comment> getCommentsByUser(User user) throws SQLException;
    public List<Comment> getCommentsByNote(Integer noteId, noteType type) throws SQLException;
    //пока так, но как-то всрато, нужно как-то через женерик вытаскивать все комменты, вопрос как послать класс в query...

}
