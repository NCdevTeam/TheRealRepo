package main.java.services;

import main.java.entities.Comment;
import main.java.entities.User;
import main.java.entities.enums.noteType;

import java.util.List;

/**
 * Created by dR34m3r on 04.05.2017.
 */

public interface CommentService {

    public List<Comment> getCommentsByNote(Integer noteId, noteType type);
    public void addComment(Comment comment, User user);
}
