package main.java.controllers;

import com.sun.org.apache.regexp.internal.RE;
import main.java.entities.Ad;
import main.java.entities.Book;
import main.java.entities.enums.adStatus;
import main.java.services.AdService;
import main.java.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dR34m3r on 25.04.2017.
 */

@Controller
public class HomeController {

    @Autowired
    BookService bookService;
    @Autowired
    AdService adService;

    @RequestMapping(method= RequestMethod.GET,value="/")
    public ModelAndView home(ModelMap map){
        map.addAttribute("title","Добро пожаловать!");
        map.addAttribute("item",adService.getAdsByStatus(adStatus.active));
        return new ModelAndView("index");
    }

    @RequestMapping(method=RequestMethod.GET,value="/search")
    public ModelAndView search(ModelMap map, @RequestParam(value="q") String searchString) {
        List<Book> bookList = bookService.searchLikeBookName(searchString);
        List<Ad> adList = adService.searchAdvertsByName(searchString);
        map.addAttribute("BookHeader","Найденные книги");
        map.addAttribute("bookList",bookList);
        map.addAttribute("AdvertHeader","Найденные объявления");
        map.addAttribute("advertList",adList);
        return new ModelAndView("searchResult");
    }

    @RequestMapping(method= RequestMethod.GET,value="/search/")
    public String nullSearch(ModelMap map) {
        return "redirect:/";
    }
}
