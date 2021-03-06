package main.java.entities;

import main.java.entities.enums.userStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

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

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

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

    @Column(name = "balance")
    private BigDecimal balance;

    //Getters

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public BigDecimal getBalance() {return this.balance;}

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setBalance(BigDecimal balance) {this.balance = balance;}
}
