package main.java.entities;

/**
 * Created by Владислав on 01.04.2017.
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column (name = "ID")
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "authorID")
    private Author author;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "downloadURL")
    private String downloadURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() { return this.author; }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageURL;
    }

    public void setImageUrl(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadUrl) {
        this.downloadURL = downloadUrl;
    }


}
