package main.java.entities;

import javax.persistence.*;

/**
 * Created by Владислав on 01.04.2017.
 */
@Entity
@Table(name = "attachments")
public class Attachment  {

    @Id
    @Column (name = "ID")
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "adsId")
    private Ad ad;

    @Column (name = "URL")
    private String Url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
