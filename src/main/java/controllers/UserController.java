package main.java.controllers;

import main.java.entities.User;
import main.java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

/**
 * Created by dR34m3r on 28.04.2017.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public String register(@ModelAttribute("NewUser")User user, ModelMap map) {
        userService.createUser(user);
        return "redirect:/books";
    }

    @RequestMapping(method = RequestMethod.GET,value="/registration")
    public ModelAndView displayRegistration(ModelMap map) {
        map.addAttribute("newUser",new User());
        return new ModelAndView("registration");
    }
}
