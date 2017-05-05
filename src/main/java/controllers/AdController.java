package main.java.controllers;

import main.java.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import main.java.DAO.AdsDAO;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;


/**
 * Created by Владислав on 24.04.2017.
 */

@Controller
@RequestMapping("/adverts")
public class AdController {

    @Autowired private AdService adService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView AdById(ModelMap map, @PathVariable("id") Integer id) throws SQLException{
        map.addAttribute("tempAd", adService.getAd(id));
        return new ModelAndView("AdDisplay");
    }



}
