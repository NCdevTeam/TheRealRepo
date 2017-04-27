package main.java.services;


import main.java.entities.Ad;

import java.sql.SQLException;
import java.util.List;

public interface AdService {
    public List<Ad> getAll() throws SQLException;
    public Ad getAd(Integer id) throws SQLException;
    public List<Ad> getAdsByBookId(Integer id) throws SQLException;
    public List<Ad> getAdsByUserId(Integer id) throws SQLException;
}
