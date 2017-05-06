package main.java.entities;

import main.java.entities.enums.userBookType;

import javax.persistence.*;

/**
 * Created by dR34m3r on 06.05.2017.
 */
@Entity
@Table(name="userbooks")
public class Userbook {

    @Id
    @GeneratedValue
    @Column(name="Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="bookId")
    private Book book;

    @Column(name="linkType")
    private userBookType type;

    public Integer getId() {return id;}

    public Book getBook() {return book;}

    public User getUser() {return user;}

    public userBookType getType() {return type;}

    public void setBook(Book book) {this.book = book;}

    public void setId(Integer id) {this.id = id;}

    public void setType(userBookType type) {this.type = type;}

    public void setUser(User user) {this.user = user;}

}
