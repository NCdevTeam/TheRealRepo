package main.java.entities.enums;

/**
 * Created by dR34m3r on 08.04.2017.
 */

public enum noteType {
    advert("/ad"),
    author("/author"),
    book("/book");

    private String url;

    noteType(String url) {
        this.url=url;
    }

    public String getUrl() {
        return url;
    }
}
