package main.java.entities;

import main.java.entities.enums.userStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Romio on 01.04.2017.
 */

@Entity
@Table(name = "user")

public class User {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "passHash")
    private String passHash;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private userStatus status;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "lastIP")
    private String lastIp;

    @Column(name = "phoneNumber")
    private String phoneNumber;


    //Getters

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassHash() {
        return passHash;
    }

    public String getEmail() {
        return email;
    }

    public userStatus getStatus() {
        return status;
    }

    public Double getRating() {
        return rating;
    }

    public String getLastIp() {
        return lastIp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassHash(String password) {
        this.passHash = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(userStatus status) {
        this.status = status;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
