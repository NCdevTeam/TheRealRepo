package main.java.DAO;

/**
 * Created by dR34m3r on 09.04.2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.pojo.Comment;
import main.java.pojo.Ad;
import main.java.pojo.Book;
import main.java.pojo.Author;
import main.java.util.interfaces.CommentsDAO;

public class CommentsDAOImpl implements CommentsDAO{
}
