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
@Table(name = "attachments")
public class Attachment  {

    @Id
    @Column (name = "ID")
    @GeneratedValue
    private Integer id;

    @Column (name = "adsId")
    private Integer adsId;

    @Column (name = "URL")
    private String Url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdsId() {
        return adsId;
    }

    public void setAdsId(Integer adsId) {
        this.adsId = adsId;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
