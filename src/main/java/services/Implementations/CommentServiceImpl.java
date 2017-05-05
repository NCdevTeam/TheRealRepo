package main.java.services.Implementations;

import main.java.DAO.CommentsDAO;
import main.java.entities.Comment;
import main.java.entities.User;
import main.java.entities.enums.noteType;
import main.java.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by dR34m3r on 04.05.2017.
 */
@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentsDAO dao;

    @Override
    public List<Comment> getCommentsByNote(Integer noteId, noteType type) {
        List<Comment> commentList = null;
        try{
            commentList = dao.getCommentsByNote(noteId,type);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return commentList;
        }
    }

    @Override
    public void addComment(Comment comment, User user) {
        try {
            comment.setUser(user);
            comment.setDateTime(new Date());
            dao.addComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
