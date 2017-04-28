package main.java.entities;

import main.java.entities.enums.adStatus;
import main.java.entities.enums.adType;

import javax.persistence.*;

/**
 * Created by Romio on 01.04.2017.
 */
@Entity
@Table (name = "ads")
public class Ad {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book book;

    @Column(name = "status")
    private adStatus status;

    @Column(name = "price")
    private Integer price;

    @Column(name = "type")
    private adType type;


    //Getters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public adStatus getStatus() {
        return status;
    }

    public Integer getPrice() {
        return price;
    }

    public adType getType() {
        return type;
    }

    public Book getBook() {
        return book;
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatus(adStatus status) {
        this.status = status;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setType(adType type) {
        this.type = type;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

