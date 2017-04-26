package main.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dR34m3r on 25.04.2017.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method= RequestMethod.GET,value="/")
    public ModelAndView home(ModelMap map){
        return new ModelAndView("index");
    }


}
