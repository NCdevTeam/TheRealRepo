package main.java.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Владислав on 01.04.2017.
 */

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column (name = "Id")
    @GeneratedValue
    private Integer id;

    @Column (name = "name")
    private String firstName;

    @Column (name = "lastName")
    private String lastName;

    @Column (name = "nickName")
    private String nickName;

    @Column (name = "description")
    private String authorDescription;

    @Column (name="photoURL")
    private String photoURL;

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String description) {
        this.authorDescription = description;
    }
}
