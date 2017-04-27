package main.java.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dR34m3r on 25.04.2017.
 */

@Controller
public class HomeController {

    @RequestMapping(method= RequestMethod.GET,value="/")
    public ModelAndView home(ModelMap map){
        map.addAttribute("title","Добро пожаловать!");
        return new ModelAndView("index");
    }

}
